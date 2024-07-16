package br.com.fiap.parkingmeter.driver.application.services;

import br.com.fiap.parkingmeter.driver.application.services.dto.CreateVehicleDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;

public interface DriverService {

    Driver createDriver(SaveDriverDto dto);

    Driver updateDriver(long driverId, SaveDriverDto dto);

    void deleteDriver(long driverId);

    Driver findById(long driverId);

    Vehicle addVehicle(long driverId, CreateVehicleDto dto);

    void deleteVehicle(long driverId, long vehicleId);

}
