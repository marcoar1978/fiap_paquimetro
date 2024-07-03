package br.com.fiap.parkingmeter.driver.application.services.dto;

import lombok.Getter;

@Getter
public class SaveDriverDto {

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

}
