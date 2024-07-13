package br.com.fiap.parkingmeter.configuration.services.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConfigurationDto {

    @NotNull(message = "Rate per hour cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rate per hour must be greater than 0")
    private BigDecimal ratePerHour;
    @NotNull(message = "Minimum time cannot be null")
    @Min(value = 1, message = "Minimum time must be at least 1 minute")
    private Integer minimumTime;
    @NotNull(message = "Currency cannot be null")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be a valid ISO currency code")
    private String currency;

}
