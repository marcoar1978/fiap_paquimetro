package br.com.fiap.parquimetro.estacionamento.domain.repositories;

import br.com.fiap.parquimetro.estacionamento.domain.model.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, UUID> {

}
