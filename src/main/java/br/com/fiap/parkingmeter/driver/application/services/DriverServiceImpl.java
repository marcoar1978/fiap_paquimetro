package br.com.fiap.parkingmeter.driver.application.services;

import br.com.fiap.parkingmeter.driver.application.services.dto.CreateVehicleDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Address;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.driver.domain.repositories.DriverRepository;
import br.com.fiap.parkingmeter.driver.domain.repositories.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public DriverServiceImpl(DriverRepository driverRepository,
                             VehicleRepository vehicleRepository) {
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    @Override
    public Driver createDriver(SaveDriverDto dto) {
        Address address = new Address(
                dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getPostalCode()
        );

        Driver driver = new Driver(
                dto.getName(), dto.getCpf(), address, dto.getPhoneNumber(), dto.getEmail(), dto.getPaymentMethod()
        );

        driverRepository.save(driver);

        return driver;
    }

    @Transactional
    @Override
    public Driver updateDriver(long driverId, SaveDriverDto dto) {
        Driver driver = findById(driverId);

        Address address = new Address(
                dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getPostalCode()
        );

        driver.updateName(dto.getName());
        driver.updateCpf(dto.getCpf());
        driver.updateAddress(address);
        driver.updatePhoneNumber(dto.getPhoneNumber());
        driver.updateEmail(dto.getEmail());
        driver.updatePaymentMethod(dto.getPaymentMethod());

        return driver;
    }

    @Transactional
    @Override
    public void deleteDriver(long driverId) {
        driverRepository.deleteById(driverId);
    }

    @Override
    public Driver findById(long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found"));
    }

    @Transactional
    @Override
    public Vehicle addVehicle(long driverId, CreateVehicleDto dto) {
        Driver driver = findById(driverId);
        Vehicle vehicle = driver.addVehicle(dto.getModel(), dto.getLicensePlate());

        vehicleRepository.save(vehicle);

        return vehicle;
    }

    @Transactional
    @Override
    public void deleteVehicle(long driverId, long vehicleId) {
        Vehicle vehicle = vehicleRepository.findByDriverIdAndId(driverId, vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));

        vehicleRepository.delete(vehicle);
    }

}
