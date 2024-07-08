package br.com.fiap.parkingmeter.driver.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    @Column(name = "license_plate")
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    Driver driver;

    public Vehicle(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

}
