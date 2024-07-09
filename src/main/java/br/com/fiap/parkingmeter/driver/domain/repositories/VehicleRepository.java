package br.com.fiap.parkingmeter.driver.domain.repositories;

import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


}