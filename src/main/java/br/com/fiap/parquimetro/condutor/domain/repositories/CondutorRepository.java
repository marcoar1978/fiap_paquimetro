package br.com.fiap.parquimetro.condutor.domain.repositories;

import br.com.fiap.parquimetro.condutor.domain.model.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
