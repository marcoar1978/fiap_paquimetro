package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.driver.domain.repositories.DriverRepository;
import br.com.fiap.parkingmeter.driver.domain.repositories.VehicleRepository;
import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

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
                dto.getTimeMinutes(),
                VALOR_POR_HORA,
                driver,
                vehicle);


        return repository.save(parking);

    }

    public void checkOut() {

    }

}
