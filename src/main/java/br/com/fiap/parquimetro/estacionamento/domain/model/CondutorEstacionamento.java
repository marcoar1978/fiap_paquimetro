package br.com.fiap.parquimetro.estacionamento.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class CondutorEstacionamento {

    @Id
    private long id;
    private String nome;

    public CondutorEstacionamento(long id) {
        this.id = id;
    }

}
