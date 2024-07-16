package br.com.fiap.parkingmeter.parking.api.controllers;

import br.com.fiap.parkingmeter.parking.application.services.ParkingService;
import br.com.fiap.parkingmeter.parking.application.services.dto.RegisterParkingDto;
import br.com.fiap.parkingmeter.parking.application.services.dto.ConfirmPaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.parkingmeter.parking.application.services.dto.TicketPreDTO;

import java.util.UUID;

@RestController
@Tag(name = "Parking", description = "API for parking operations")
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {
        this.service = service;
    }

    @PostMapping("/register-parking")
    @Operation(summary = "Parking check-in", description = "Performs a check-in at a parking lot with the provided details.")
    public ResponseEntity<TicketPreDTO> registerParking(@RequestBody @Valid RegisterParkingDto dto){
        var ret = service.registerParking(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TicketPreDTO(ret));
    }

    @PutMapping("/close-parking/{parkingId}")
    @Operation(summary = "close parking pos", description = "close parking pos.")
    public ResponseEntity<TicketPreDTO> closeParking(@PathVariable UUID parkingId){
        var ret = service.closeParking(parkingId);
        return ResponseEntity.ok(new TicketPreDTO(ret));
    }

    @PutMapping("/confirm-payment/{parkingId}")
    @Operation(summary = "Parking confirm payment", description = "Confirm payment.")
    public ResponseEntity<TicketPreDTO> confirmPayment(@PathVariable UUID parkingId){
       var ret = service.confirmPayment(parkingId);
       return ResponseEntity.ok(new TicketPreDTO(ret));
    }

}
