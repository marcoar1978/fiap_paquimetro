package com.estudo.paquimetro.domain.dto;

import com.estudo.paquimetro.domain.model.CheckInEstacionamento;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class CheckInEstacionamentoDto {

    private Long numeroTycket;
    @Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "placa inválida")
    private String placa;
    @Min(value=0, message = "Não pode inserir quantidade de horas negativas" )
    @Max(value=8, message = "Limite é de 8 horas")
    private Integer qdeHoras;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private BigDecimal valor;

    public  CheckInEstacionamentoDto() {}

    public CheckInEstacionamentoDto(CheckInEstacionamento checkInEstacionamento) {
        this.numeroTycket = checkInEstacionamento.getNumeroTicket();
        this.placa = checkInEstacionamento.getPlaca();
        this.qdeHoras = checkInEstacionamento.getHoras();
        this.entrada = checkInEstacionamento.getEntrada();
        this.saida = checkInEstacionamento.getSaida();
        this.valor = checkInEstacionamento.getValor();
    }

    public CheckInEstacionamento toEntity(){
        CheckInEstacionamento checkInEstacionamento = new CheckInEstacionamento();
        checkInEstacionamento.setNumeroTicket(this.getNumeroTycket());
        checkInEstacionamento.setPlaca(this.getPlaca());
        checkInEstacionamento.setHoras(this.getQdeHoras());
        checkInEstacionamento.setEntrada(this.getEntrada());
        checkInEstacionamento.setSaida(this.getSaida());
        checkInEstacionamento.setValor(this.getValor());

        return checkInEstacionamento;
    }
}
