package br.com.fiap.parkingmeter.driver.application.services;

import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Address;
import br.com.fiap.parkingmeter.driver.domain.repositories.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public long createDriver(SaveDriverDto dto) {
        Address address = new Address(
                dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getPostalCode()
        );

        Driver driver = new Driver(
                dto.getName(), dto.getCpf(), address, dto.getPhoneNumber(), dto.getEmail()
        );

        driverRepository.save(driver);

        return driver.getId();
    }

    @Override
    public void updateDriver(long driverId, SaveDriverDto dto) {
        Driver condutor = findById(driverId);

        Address address = new Address(
                dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getPostalCode()
        );

        condutor.updateName(dto.getName());
        condutor.updateCpf(dto.getCpf());
        condutor.updateAddress(address);
        condutor.updatePhoneNumber(dto.getPhoneNumber());
        condutor.updateEmail(dto.getEmail());

    }

    @Override
    public void deleteDriver(long driverId) {
        driverRepository.deleteById(driverId);
    }

    @Override
    public Driver findById(long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(()-> new IllegalArgumentException("Condutor não encontrado."));
    }

    @Override
    public void addVehicle(long driverId, VehicleDto dto) {
        Driver driver = findById(driverId);
        driver.addVehicle(dto.getModel(), dto.getLicensePlate());
    }

    @Override
    public void deleteVehicle(long driverId, long vehicleId) {
        Driver driver = findById(driverId);
        driver.deleteVehicle(vehicleId);
    }

}
