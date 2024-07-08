package br.com.fiap.parkingmeter.parking.api.controllers;

import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.parkingmeter.parking.application.services.dto.TicketPreDTO;

@RestController
@Tag(name = "Parking", description = "API for parking operations")
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingService service;

    @PostMapping("/checkIn")
    @Operation(summary = "Parking check-in", description = "Performs a check-in at a parking lot with the provided details.")
    public ResponseEntity<TicketPreDTO> checkIn(@RequestBody @Valid CheckInParkingDto dto){
        var ret = service.registerParking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TicketPreDTO(ret));
    }

}
