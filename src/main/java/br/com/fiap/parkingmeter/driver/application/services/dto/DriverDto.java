package br.com.fiap.parkingmeter.driver.application.services.dto;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DriverDto {

    private long id;
    private String name;
    private String cpf;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String postalCode;
    private String phoneNumber;
    private String email;
    //private List<VehicleDto> vehicles;

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.cpf = driver.getCpf();
        this.street = driver.getAddress().getStreet();
        this.number = driver.getAddress().getNumber();
        this.complement = driver.getAddress().getComplement();
        this.district = driver.getAddress().getDistrict();
        this.city = driver.getAddress().getCity();
        this.state = driver.getAddress().getState();
        this.postalCode = driver.getAddress().getPostalCode();
        this.phoneNumber = driver.getPhoneNumber();
        this.email = driver.getEmail();
        //this.vehicles = VehicleDto.toList(driver.getVehicles());
    }
}
