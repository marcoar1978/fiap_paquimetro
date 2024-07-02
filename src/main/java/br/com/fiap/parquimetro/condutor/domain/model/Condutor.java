package br.com.fiap.parquimetro.condutor.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Condutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private String contato;
    private String email;
    @OneToMany
    private List<Veiculo> veiculos;

    public Condutor(String nome, String cpf, Endereco endereco, String contato, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.contato = contato;
        this.email = email;
    }

    public void adicionarVeiculo(String modelo, String placa){
        Veiculo veiculo = new Veiculo(modelo, placa);
        // TODO DEFINIR
    }

}
