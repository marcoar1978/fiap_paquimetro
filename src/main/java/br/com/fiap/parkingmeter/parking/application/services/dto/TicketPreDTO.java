package br.com.fiap.parkingmeter.parking.application.services.dto;

import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import br.com.fiap.parkingmeter.parking.domain.model.Parking;
import br.com.fiap.parkingmeter.parking.domain.model.ParkingType;
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

    private DriverDto driver;

    private String licensePlate;

    private Double value;

    public TicketPreDTO(Parking parking){
        this.ticketNumber = parking.getTicketNumber();
        this.type = parking.getType();
        this.startTime = parking.getStartTime();
        this.endTime = parking.getEndTime();
        this.driver = new DriverDto(parking.getDriver());
        this.licensePlate = parking.getVehicle().getLicensePlate();
        this.value = parking.getValue();
        //status
        //forma de pagamento



    }
}
