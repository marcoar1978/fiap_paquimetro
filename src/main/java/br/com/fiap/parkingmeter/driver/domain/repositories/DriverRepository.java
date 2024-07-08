package br.com.fiap.parkingmeter.driver.domain.repositories;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}