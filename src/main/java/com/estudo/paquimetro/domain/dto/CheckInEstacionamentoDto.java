package com.estudo.paquimetro.domain.dto;

import com.estudo.paquimetro.domain.model.CheckInEstacionamento;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class CheckInEstacionamentoDto {

    private Long numeroTycket;
    private String placa;
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
