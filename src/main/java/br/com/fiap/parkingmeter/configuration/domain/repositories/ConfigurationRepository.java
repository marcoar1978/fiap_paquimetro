package br.com.fiap.parkingmeter.configuration.domain.repositories;

import br.com.fiap.parkingmeter.configuration.domain.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {

    Configuration findTopByOrderByIdDesc();
}
