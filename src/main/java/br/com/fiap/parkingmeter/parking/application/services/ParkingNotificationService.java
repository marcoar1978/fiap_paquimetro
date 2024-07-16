package br.com.fiap.parkingmeter.parking.application.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ParkingNotificationService {

    private final ParkingService parkingService;

    public ParkingNotificationService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }


    @Scheduled(fixedDelay = 60000L)
    public void notificar() {

    }


}
