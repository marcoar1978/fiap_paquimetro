package br.com.fiap.parkingmeter.driver.application.services;

import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import br.com.fiap.parkingmeter.driver.domain.model.Driver;

public interface DriverService {

    long createDriver(SaveDriverDto dto);

    void updateDriver(long driverId, SaveDriverDto dto);

    void deleteDriver(long driverId);

    Driver findById(long driverId);

    void addVehicle(long driverId, VehicleDto dto);

    void deleteVehicle(long driverId, long vehicleId);

}
