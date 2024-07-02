package br.com.fiap.parquimetro.condutor.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
