package br.com.fiap.parkingmeter.parking.application.services.dto;

import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class RegisterParkingDto {

    private ParkingType type;
    @Min(value=0, message = "Não pode inserir quantidade de horas negativas" )
    @Max(value=480, message = "Limite é de 8 horas")
    private Long time;
    private Long driverId;
    private Long vehicleId;

}
