package br.com.fiap.parkingmeter.parking.domain.repositories;

import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ParkingRepository extends JpaRepository<Parking, UUID> {

    List<Parking> findAllByTypeAndEndTime(ParkingType type, LocalDateTime endTime);

}
