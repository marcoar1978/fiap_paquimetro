package br.com.fiap.parquimetro.estacionamento.application.services;

import br.com.fiap.parquimetro.estacionamento.api.controllers.dto.CheckInEstacionamentoDto;
import br.com.fiap.parquimetro.estacionamento.domain.model.Estacionamento;
import br.com.fiap.parquimetro.estacionamento.domain.repositories.EstacionamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstacionamentoService {

    private final EstacionamentoRepository repository;

    public EstacionamentoService(EstacionamentoRepository repository) {
        this.repository = repository;
    }

    public CheckInEstacionamentoDto checkIn(CheckInEstacionamentoDto dto) {
        Estacionamento estacionamento = new Estacionamento();

        return new CheckInEstacionamentoDto(repository.save(estacionamento));
    }

    public void checkOut() {

    }

}
