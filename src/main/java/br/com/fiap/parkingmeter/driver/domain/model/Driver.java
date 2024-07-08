package br.com.fiap.parkingmeter.driver.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpf;
    @Embedded
    private Address address;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles;

    public Driver(String name, String cpf, Address address, String phoneNumber, String email) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void updateName(String name) {
        if (!this.name.equals(name)){
            this.name = name;
        }
    }

    public void updateCpf(String cpf) {
        if (!this.cpf.equals(cpf)){
            this.cpf = cpf;
        }
    }

    public void updateAddress(Address address) {
        if (!this.address.equals(address)){
            this.address = address;
        }
    }

    public void updatePhoneNumber(String phoneNumber) {
        if (!this.phoneNumber.equals(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
    }

    public void updateEmail(String email) {
        if (!this.email.equals(email)){
            this.email = email;
        }
    }

    public void addVehicle(String model, String plate){
        Vehicle vehicle = new Vehicle(model, plate);
        vehicles.add(vehicle);
    }

    public void deleteVehicle(long vehicleId){
        vehicles.removeIf(p -> p.getId() == vehicleId);
    }

}
