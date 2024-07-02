package br.com.fiap.parquimetro.condutor.api.controllers;

import br.com.fiap.parquimetro.condutor.application.services.CondutorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estacionamento")
public class CondutorController {

    private final CondutorService condutorService;

    public CondutorController(CondutorService condutorService) {
        this.condutorService = condutorService;
    }



}
