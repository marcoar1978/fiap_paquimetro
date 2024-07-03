package br.com.fiap.parkingmeter.parking.api.controllers;

import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamento")
public class ParkingController {

    @Autowired
    ParkingService service;

    @PostMapping("/checkIn")
    public ResponseEntity<CheckInParkingDto> checkIn(@RequestBody @Valid CheckInParkingDto dto){
        var ret = service.checkIn(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ret);
    }

}
