package com.estudo.paquimetro.domain.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "checkin_estacionamento")
@Entity
public class CheckInEstacionamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero_ticket")
    private Long numeroTicket;

    private String placa;

    @Column(name="qde_horas")
    private Integer horas;

    private LocalDateTime entrada;

    private LocalDateTime saida;

    private BigDecimal valor;

}
