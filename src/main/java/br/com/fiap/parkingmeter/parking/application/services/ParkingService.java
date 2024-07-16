package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.parking.application.services.dto.RegisterParkingDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;

import java.util.UUID;

public interface ParkingService {

    Parking registerParking(RegisterParkingDto dto);

    Parking closeParking(UUID parkingId);

    Parking confirmPayment(UUID parkingId);

}
