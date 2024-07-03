package br.com.fiap.parkingmeter.driver.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    @Column(name = "postal_code")
    private String postalCode;

}
