package br.com.fiap.parkingmeter.parking.application.services.dto;

import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class RegisterParkingDto {

    @NotNull(message = "field type is PRE or POS")
    private ParkingType type;
    private Long time;

    @NotNull(message = "field driverId cannot be null")
    private Long driverId;

    @NotNull(message = "field vehicleId cannot be null")
    private Long vehicleId;

}
