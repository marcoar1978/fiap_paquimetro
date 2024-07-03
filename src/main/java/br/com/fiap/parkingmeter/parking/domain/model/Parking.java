package br.com.fiap.parkingmeter.parking.domain.model;

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
    @Column(name = "ticket_number")
    private UUID ticketNumber;
    @Enumerated(EnumType.STRING)
    private ParkingType type;
    @NotNull
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double value;
    @JoinColumn(name = "license_plate")
    private String licensePlate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private CarDriver driver;

//    public Parking(ParkingType type, LocalDateTime startTime, LocalDateTime endTime, double value, String licensePlate, CarDriver driver) {
//        this.type = type;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.value = value;
//        this.licensePlate = licensePlate;
//        this.driver = driver;
//    }
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
