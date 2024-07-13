package br.com.fiap.parkingmeter.parking.application.services.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ConfirmPaymentDto {


    private UUID parkingId;

    private String paymentForm;
}
