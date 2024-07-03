package br.com.fiap.parkingmeter.parking.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class CarDriver {

    @Id
    private long id;
    private String nome;

    public CarDriver(long id) {
        this.id = id;
    }

}
