package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ParkingNotificationService {

    private final ParkingRepository parkingRepository;

    public ParkingNotificationService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Scheduled(fixedDelay = 60000L)
    public void notificar() {

    }


}
