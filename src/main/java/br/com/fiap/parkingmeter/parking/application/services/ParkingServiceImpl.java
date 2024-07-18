package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.configuration.services.ConfigurationService;
import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.driver.domain.repositories.DriverRepository;
import br.com.fiap.parkingmeter.driver.domain.repositories.VehicleRepository;
import br.com.fiap.parkingmeter.parking.application.services.dto.RegisterParkingDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import br.com.fiap.parkingmeter.parking.infrastructure.payment_gateway.AuthorizePaymentDto;
import br.com.fiap.parkingmeter.parking.infrastructure.payment_gateway.PaymentGatewayService;
import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepository repository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final PaymentGatewayService paymentService;
    private ConfigurationService configurationService;
    private final Double ratePerHour;


    public ParkingServiceImpl(ParkingRepository repository, DriverRepository driverRepository,
                              VehicleRepository vehicleRepository, PaymentGatewayService paymentService,
                              ConfigurationService configurationService) {
        this.repository = repository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.paymentService = paymentService;
        this.ratePerHour = configurationService.getConfiguration().getRatePerHour().doubleValue();
    }

    @Transactional
    public Parking registerParking(RegisterParkingDto dto) {
        Driver driver = this.driverRepository.findById(dto.getDriverId()).orElseThrow(() -> new RuntimeException("Driver not found"));
        Vehicle vehicle = this.vehicleRepository.findById(dto.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Parking parking = new Parking(dto.getType(),
                dto.getTime(),
                ratePerHour,
                driver,
                vehicle);

        if (parking.getType() == ParkingType.PRE && parking.getPaymentMethod() != PaymentMethod.PIX) {
            payParking(parking);
        }

        return repository.save(parking);
    }

    @Transactional
    public Parking closeParking(UUID parkingId) {
        Parking parking = this.repository.findById(parkingId).orElseThrow(() -> new RuntimeException("Parking not found"));
        parking.close(ratePerHour);

        payParking(parking);

        return parking;
    }

    @Transactional
    public Parking confirmPayment(UUID parkingId) {
        Parking parking = this.repository.findById(parkingId).orElseThrow(() -> new RuntimeException("Parking not found"));

        payParking(parking);

        return parking;
    }


    private Parking payParking(Parking parking) {
        String paymentAuth = paymentService.authorizePayment(
                new AuthorizePaymentDto(parking.getTicketNumber(), parking.getValue(), parking.getPaymentMethod())
        );

        parking.confirmPayment(paymentAuth);

        return parking;
    }



}
