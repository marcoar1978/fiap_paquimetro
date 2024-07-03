package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    private final ParkingRepository repository;

    public ParkingService(ParkingRepository repository) {
        this.repository = repository;
    }

    public CheckInParkingDto checkIn(CheckInParkingDto dto) {
        Parking parking = new Parking();

        return new CheckInParkingDto(repository.save(parking));
    }

    public void checkOut() {

    }

}
