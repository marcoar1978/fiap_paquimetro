package br.com.fiap.parkingmeter.parking.application.services.dto;

import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ConfirmPaymentDto {


    private UUID parkingId;

    private PaymentMethod paymentMethod;

}
