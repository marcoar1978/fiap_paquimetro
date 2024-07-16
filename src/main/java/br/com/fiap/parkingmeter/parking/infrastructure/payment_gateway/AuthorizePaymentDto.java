package br.com.fiap.parkingmeter.parking.infrastructure.payment_gateway;

import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class AuthorizePaymentDto {

    private UUID ticketNumber;
    private double value;
    private PaymentMethod paymentMethod;

}
