package com.estudo.paquimetro.controller;

import com.estudo.paquimetro.domain.dto.CheckInEstacionamentoDto;
import com.estudo.paquimetro.service.EstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    @Autowired
    EstacionamentoService service;

    @PostMapping("/checkIn")
    public ResponseEntity<CheckInEstacionamentoDto> checkIn(@RequestBody @Valid CheckInEstacionamentoDto dto){
        var ret = service.checkIn(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ret);
    }

}
