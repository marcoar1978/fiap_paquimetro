package br.com.fiap.parkingmeter.driver.api.controllers;

import br.com.fiap.parkingmeter.driver.application.services.DriverService;
import br.com.fiap.parkingmeter.driver.application.services.dto.CreateVehicleDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Driver", description = "API for driver management")
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    @Operation(summary = "Create a new driver", description = "Creates a new driver with the given details.")
    public ResponseEntity<DriverDto> createDriver(@RequestBody @Valid SaveDriverDto dto) {
        var ret = driverService.createDriver(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DriverDto(ret));
    }

    @PutMapping("/{driverId}")
    @Operation(summary = "Update an existing driver", description = "Updates the details of an existing driver.")
    public ResponseEntity<DriverDto> updateDriver(@PathVariable long driverId,
                                                  @RequestBody @Valid SaveDriverDto dto) {
        var ret = driverService.updateDriver(driverId, dto);
        return ResponseEntity.ok(new DriverDto(ret));
    }

    @DeleteMapping("/{driverId}")
    @Operation(summary = "Delete a driver", description = "Deletes the driver with the given ID.")
    public void deleteDriver(@PathVariable long driverId) {
        driverService.deleteDriver(driverId);
    }

    @GetMapping("/{driverId}")
    @Operation(summary = "Find driver by ID", description = "Finds and returns the driver with the given ID.")
    public ResponseEntity<DriverDto> findById(@PathVariable long driverId) {
        var ret = driverService.findById(driverId);
        return ResponseEntity.ok(new DriverDto(ret));
    }

    @PostMapping("/{driverId}/vehicle")
    @Operation(summary = "Add a vehicle to a driver", description = "Adds a vehicle to the driver with the given ID.")
    public ResponseEntity<VehicleDto> addVehicle(@PathVariable long driverId,
                                                 @RequestBody @Valid CreateVehicleDto dto) {
        var ret = driverService.addVehicle(driverId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new VehicleDto(ret));
    }

    @DeleteMapping("/{driverId}/vehicle/{vehicleId}")
    @Operation(summary = "Delete a vehicle from a driver", description = "Deletes the vehicle with the given ID from the driver with the given ID.")
    public void deleteVehicle(long driverId, long vehicleId) {
        driverService.deleteVehicle(driverId, vehicleId);
    }

}
