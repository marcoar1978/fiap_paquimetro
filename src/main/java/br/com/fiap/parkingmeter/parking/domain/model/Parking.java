package br.com.fiap.parkingmeter.parking.domain.model;

import br.com.fiap.parkingmeter.driver.domain.model.Driver;
import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    //Status

    public Parking(ParkingType type, Long minutes, Double hourValue, Driver driver, Vehicle vehicle) {

        this.ticketNumber = UUID.randomUUID();
        this.type = type;
        this.startTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.driver = driver;
        if(this.type == ParkingType.PRE){

            this.endTime = this.startTime.plusMinutes(minutes);
            this.value = (minutes/60.0) * hourValue;

        }
        else{
            this.endTime = this.startTime.plusMinutes(60);
        }



    }
//
//    public Parking(ParkingType tipo, int minutos, double valorMinuto,
//                   String placaVeiculo, CarDriver condutor) {
//        this.tipo = tipo;
//        this.entrada = LocalDateTime.now();
//        this.placaVeiculo = placaVeiculo;
//        this.condutor = condutor;
//
//        if (tipo == ParkingType.PRE) {
//            this.saida = this.entrada.plusMinutes(minutos);
//            this.valor = minutos * valorMinuto;
//        }
//    }

}
