package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import br.com.fiap.parkingmeter.parking.domain.repositories.ParkingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParkingNotificationService {

    private final ParkingRepository parkingRepository;

    public ParkingNotificationService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Scheduled(fixedDelay = 60000L)
    public void notifyExpireTime() {
        List<Parking> list =  parkingRepository.findAllByTypeAndEndTime(ParkingType.PRE, LocalDateTime.now().minusMinutes(5));
        for (Parking parking : list) {
            System.out.printf("ID: %s. Time expire in 5 minutes.", parking.getTicketNumber());
            System.out.println(parking.getEndTime());
        }
    }

    @Scheduled(fixedDelay = 60000L)
    @Transactional
    public void notifyAutoRenew() {
        List<Parking> list =  parkingRepository.findAllByTypeAndEndTime(ParkingType.PRE, LocalDateTime.now().minusMinutes(5));
        for (Parking parking : list) {
            parking.plusHour();

            System.out.printf("ID: %s. Time renew in 5 minutes.", parking.getTicketNumber());
            System.out.println(parking.getEndTime());
        }
    }

}
