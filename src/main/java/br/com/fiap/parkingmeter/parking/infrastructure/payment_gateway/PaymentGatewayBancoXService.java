package br.com.fiap.parkingmeter.parking.infrastructure.payment_gateway;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentGatewayBancoXService implements PaymentGatewayService {

    @Override
    public String authorizePayment(AuthorizePaymentDto dto) {
        switch (dto.getPaymentMethod()) {
            case CREDIT_CARD -> {
                return String.format("CREDITAUTH:%.2f:%s", dto.getValue(), UUID.randomUUID());
            }
            case DEBIT_CARD -> {
                return String.format("DEBITAUTH:%.2f:%s", dto.getValue(), UUID.randomUUID());
            }
            case PIX -> {
                return String.format("PIXUUID:%.2f:%s", dto.getValue(), UUID.randomUUID());
            }
        }
        throw new RuntimeException("Pix is not allowed for POS mode");
    }

}
