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
public class CheckInParkingDto {

    private ParkingType type;
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "placa inválida")
    private String licensePlate;
    @Min(value=0, message = "Não pode inserir quantidade de horas negativas" )
    @Max(value=480, message = "Limite é de 8 horas")
    private Long timeMinutes;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BigDecimal value;
    private Long driverId;
    private Long vehicleId;


    public CheckInParkingDto() {}

    public CheckInParkingDto(Parking parking) {

    }

//    public Estacionamento toEntity(){
//        Estacionamento checkInEstacionamento = new Estacionamento();
//        checkInEstacionamento.setNumeroTicket(this.getNumeroTycket());
//        checkInEstacionamento.setPlaca(this.getPlaca());
//        checkInEstacionamento.setHoras(this.getQdeHoras());
//        checkInEstacionamento.setEntrada(this.getEntrada());
//        checkInEstacionamento.setSaida(this.getSaida());
//        checkInEstacionamento.setValor(this.getValor());
//
//        return checkInEstacionamento;
//    }
}
