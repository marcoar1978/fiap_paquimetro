package br.com.fiap.parkingmeter.parking.infrastructure.payment_gateway;

public interface PaymentGatewayService {

    String authorizePayment(AuthorizePaymentDto dto);

}
