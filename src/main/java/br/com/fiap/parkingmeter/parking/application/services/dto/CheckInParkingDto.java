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

    private ParkingType tipo;
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "placa inválida")
    private String placa;
    @Min(value=0, message = "Não pode inserir quantidade de horas negativas" )
    @Max(value=8, message = "Limite é de 8 horas")
    private Integer qdeHoras;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private BigDecimal valor;

    public CheckInParkingDto() {}

    public CheckInParkingDto(Parking checkInEstacionamento) {
//        this.numeroTycket = checkInEstacionamento.getNumeroTicket();
//        this.placa = checkInEstacionamento.getPlaca();
//        this.qdeHoras = checkInEstacionamento.getHoras();
//        this.entrada = checkInEstacionamento.getEntrada();
//        this.saida = checkInEstacionamento.getSaida();
//        this.valor = checkInEstacionamento.getValor();
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
