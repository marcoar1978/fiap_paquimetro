package br.com.fiap.parkingmeter.parking.application.services;

import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.dto.ConfirmPaymentDto;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;

import java.util.UUID;

public interface ParkingService {

    public Parking registerParking(CheckInParkingDto dto);

    public Parking confirmParking(ConfirmPaymentDto dto);

    public Parking closeParking(UUID pargingId);

    public Parking renovationParking(UUID parkingId);
}
