package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.driver.domain.repositories.DriverRepository;
import br.com.fiap.parkingmeter.driver.domain.repositories.VehicleRepository;
import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.dto.ConfirmPaymentDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingStatus;
import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    private final ParkingRepository repository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    private final Double VALOR_POR_HORA = 2.0;


    public ParkingService(ParkingRepository repository, DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.repository = repository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Parking registerParking(CheckInParkingDto dto) {
        Driver driver = this.driverRepository.findById(dto.getDriverId()).orElseThrow(() -> new RuntimeException("Driver not found"));
        Vehicle vehicle = this.vehicleRepository.findById(dto.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Parking parking = new Parking(dto.getType(),
                dto.getTime(),
                VALOR_POR_HORA,
                driver,
                vehicle);

        return repository.save(parking);

    }

    @Transactional
    public Parking confirmParking(ConfirmPaymentDto dto){

        Parking parking = this.repository.findById(dto.getParkingId()).orElseThrow(() -> new RuntimeException("Parking not found"));
        parking.updateStatus(ParkingStatus.CONFIRMED);

        return parking;
    }

    @Transactional
    public Parking closeParking(UUID pargingId){

        Parking parking = this.repository.findById(pargingId).orElseThrow(() -> new RuntimeException("Parking not found"));
        parking.updateStatus(ParkingStatus.PENDENT_PAYMENT);
        parking.updateValue(VALOR_POR_HORA);

        return parking;
    }

   @Transactional
   public Parking renovationParking(UUID pargingId){
       Parking parking = this.repository.findById(pargingId).orElseThrow(() -> new RuntimeException("Parking not found"));
       parking.plusHour();

       return parking;
   }

}
