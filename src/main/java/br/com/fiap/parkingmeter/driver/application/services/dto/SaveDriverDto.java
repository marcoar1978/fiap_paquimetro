package br.com.fiap.parkingmeter.driver.application.services.dto;

import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import jakarta.validation.constraints.*;
import lombok.Getter;


@Getter
public class SaveDriverDto {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 60, message = "Name should not exceed 60 characters")
    private String name;

    @NotBlank(message = "CPF is mandatory")
    @Pattern(regexp = "\\d{11}", message = "CPF should be exactly 11 digits")
    private String cpf;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "Number is mandatory")
    private String number;

    private String complement;

    @NotBlank(message = "District is mandatory")
    private String district;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    @Size(max = 2, message = "State should be a valid two-letter abbreviation")
    private String state;

    @NotBlank(message = "Postal Code is mandatory")
    @Pattern(regexp = "\\d{8}", message = "Postal Code should be exactly 8 digits")
    private String postalCode;

    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp = "\\d{10,11}", message = "Phone Number should be 10 or 11 digits")
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Payment Method is mandatory")
    private PaymentMethod paymentMethod;

}
