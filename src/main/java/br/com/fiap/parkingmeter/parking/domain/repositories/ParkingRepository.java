package br.com.fiap.parkingmeter.parking.domain.repositories;

import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingRepository extends JpaRepository<Parking, UUID> {

}
