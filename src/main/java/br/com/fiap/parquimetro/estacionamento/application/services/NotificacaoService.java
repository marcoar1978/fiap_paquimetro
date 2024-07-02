package br.com.fiap.parquimetro.estacionamento.application.services;

import br.com.fiap.parquimetro.estacionamento.domain.repositories.EstacionamentoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    private final EstacionamentoRepository estacionamentoRepository;

    public NotificacaoService(EstacionamentoRepository estacionamentoRepository) {
        this.estacionamentoRepository = estacionamentoRepository;
    }

    @Scheduled(fixedDelay = 60000L)
    public void notificar() {

    }


}
