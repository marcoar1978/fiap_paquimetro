package br.com.fiap.parkingmeter.driver.domain.model;

import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "driver_id")
    private List<Vehicle> vehicles = new ArrayList<>();

    public Driver(String name, String cpf, Address address, String phoneNumber, String email, PaymentMethod paymentMethod) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.paymentMethod = paymentMethod;
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


    public void updatePaymentMethod(PaymentMethod paymentMethod) {
        if (this.paymentMethod == paymentMethod){
            this.paymentMethod = paymentMethod;
        }
    }

    public Vehicle addVehicle(String model, String plate){
        return new Vehicle(model, plate, this);
    }

}
