package br.com.fiap.parkingmeter.driver.domain.repositories;

import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByDriverIdAndId(long driverId, long vehicleId);

}