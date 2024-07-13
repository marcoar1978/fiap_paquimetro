package br.com.fiap.parkingmeter.parking.domain.model;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticketnumber")
    private UUID ticketNumber;
    @Enumerated(EnumType.STRING)
    private ParkingType type;
    @NotNull
    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;
    private Double value;

    @Enumerated(EnumType.STRING)
    private ParkingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    public Parking(ParkingType type, Long time, Double hourValue, Driver driver, Vehicle vehicle) {

        this.ticketNumber = UUID.randomUUID();
        this.type = type;
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.driver = driver;
        if(this.type == ParkingType.PRE){

            this.endTime = this.startTime.plusHours(time);
            this.value = time * hourValue;
            this.status = ParkingStatus.PENDENT_PAYMENT;

        }
        else{
            this.endTime = this.startTime.plusMinutes(60);
            this.status = ParkingStatus.STARTED;
        }
     }

    public  void updateStatus(ParkingStatus parkingStatus){
        this.status = parkingStatus;
    }

    public void updateValue(Double hourValue){
        Long hours = ChronoUnit.HOURS.between(this.getStartTime(), this.getEndTime());
        this.value = hours * hourValue;
    }

    public void plusHour(){
        this.endTime = this.endTime.plusHours(1);

    }
}
