package br.com.fiap.parquimetro.estacionamento.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "numero_ticket")
    private UUID numeroTicket;
    @Enumerated(EnumType.STRING)
    private TipoEstacionamento tipo;
    @NotNull
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private double valor;
    @JoinColumn(name = "placa_veiculo")
    private String placaVeiculo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "condutor_id")
    private CondutorEstacionamento condutor;

    public Estacionamento(TipoEstacionamento tipo, int minutos, double valorMinuto,
                          String placaVeiculo, CondutorEstacionamento condutor) {
        this.tipo = tipo;
        this.entrada = LocalDateTime.now();
        this.placaVeiculo = placaVeiculo;
        this.condutor = condutor;

        if (tipo == TipoEstacionamento.PRE) {
            this.saida = this.entrada.plusMinutes(minutos);
            this.valor = minutos * valorMinuto;
        }
    }

}
