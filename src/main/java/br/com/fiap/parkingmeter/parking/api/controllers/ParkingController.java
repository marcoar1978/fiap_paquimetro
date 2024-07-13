package br.com.fiap.parkingmeter.parking.api.controllers;

import br.com.fiap.parkingmeter.parking.application.services.ParkingService;
import br.com.fiap.parkingmeter.parking.application.services.dto.CheckInParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.dto.ConfirmPaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.parkingmeter.parking.application.services.dto.TicketPreDTO;

import java.util.UUID;

@RestController
@Tag(name = "Parking", description = "API for parking operations")
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingService service;

    @PostMapping("/registerParking")
    @Operation(summary = "Parking check-in", description = "Performs a check-in at a parking lot with the provided details.")
    public ResponseEntity<TicketPreDTO> registerParking(@RequestBody @Valid CheckInParkingDto dto){
        var ret = service.registerParking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TicketPreDTO(ret));
    }

    @PostMapping("/confirmParking")
    @Operation(summary = "Parking confirm payment", description = "Confirm payment.")
    public ResponseEntity<TicketPreDTO> confirmParking(@RequestBody @Valid ConfirmPaymentDto dto){
       var ret = service.confirmParking(dto);
       return ResponseEntity.ok(new TicketPreDTO(ret));
    }

    @GetMapping("/closeParking/{parkingId}")
    @Operation(summary = "close parking pos", description = "close parking pos.")
    public ResponseEntity<TicketPreDTO> closeParking(@PathVariable UUID parkingId){
        var ret = service.closeParking(parkingId);
        return ResponseEntity.ok(new TicketPreDTO(ret));
    }

    @GetMapping("/renovationParking/{parkingId}")
    @Operation(summary = "renovation parking pos", description = "close parking pos.")
    public ResponseEntity<TicketPreDTO> renovationParking(@PathVariable UUID parkingId) {
        var ret = service.renovationParking(parkingId);
        return ResponseEntity.ok(new TicketPreDTO(ret));
    }



}
