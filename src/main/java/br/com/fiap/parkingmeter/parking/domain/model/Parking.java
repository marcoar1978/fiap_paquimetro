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

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    @Column(name = "payment_auth")
    private String paymentAuth;

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
        this.paymentMethod = driver.getPaymentMethod();

        if (this.type == ParkingType.PRE) {
            this.endTime = this.startTime.plusHours(time);
            this.value = time * hourValue;
            this.status = ParkingStatus.PENDENT_PAYMENT;
        } else {
            if (this.driver.getPaymentMethod() == PaymentMethod.PIX) {
                throw new RuntimeException("Pix is not allowed for POS mode");
            }
            this.endTime = this.startTime.plusHours(1);
            this.status = ParkingStatus.STARTED;
        }
    }

    public void close(Double hourValue) {
        this.endTime = LocalDateTime.now();

        if(this.type.equals(ParkingType.POS)) {
            Long hours = ChronoUnit.HOURS.between(this.startTime, this.endTime);

            // Check if there's any fraction of an hour
            if (this.startTime.until(this.endTime, ChronoUnit.MINUTES) % 60 != 0) {
                hours++;
            }

            if(hours == 0) hours = 1L;

            this.value = hours * hourValue;
        }
    }

    public void confirmPayment(String paymentAuth) {
        this.paymentAuth = paymentAuth;
        this.status = ParkingStatus.CONFIRMED;
    }

}
