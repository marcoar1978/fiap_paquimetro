package br.com.fiap.parkingmeter.parking.application.services.dto;

import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingStatus;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
import br.com.fiap.parkingmeter.parking.domain.model.PaymentMethod;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@NoArgsConstructor
public class TicketPreDTO {

    private UUID ticketNumber;

    private ParkingType type;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String name;

    private String cpf;

    private String model;

    private String licensePlate;

    private PaymentMethod paymentMethod;

    private Double value;

    private ParkingStatus status;

    public TicketPreDTO(Parking parking){
        this.ticketNumber = parking.getTicketNumber();
        this.type = parking.getType();
        this.startTime = parking.getStartTime();
        this.endTime = parking.getEndTime();
        this.name = parking.getDriver().getName();
        this.cpf = parking.getDriver().getCpf();
        this.paymentMethod = parking.getDriver().getPaymentMethod();
        this.model = parking.getVehicle().getModel();
        this.licensePlate = parking.getVehicle().getLicensePlate();
        this.value = parking.getValue();

        this.status = parking.getStatus();

    }
}
