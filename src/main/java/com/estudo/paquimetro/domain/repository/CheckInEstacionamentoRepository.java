package com.estudo.paquimetro.domain.repository;

import com.estudo.paquimetro.domain.model.CheckInEstacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckInEstacionamentoRepository extends JpaRepository<CheckInEstacionamento, UUID> {

}
