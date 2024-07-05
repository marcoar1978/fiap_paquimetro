package br.com.fiap.parkingmeter.driver.api.controllers;

import br.com.fiap.parkingmeter.driver.application.services.DriverService;
import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public long createDriver(@RequestBody @Valid SaveDriverDto dto) {
        return driverService.createDriver(dto);
    }

    @PutMapping("/{driverId}")
    @Operation(summary = "Update an existing driver", description = "Updates the details of an existing driver.")
    public void updateDriver(@PathVariable long driverId,
                             @RequestBody @Valid SaveDriverDto dto) {
        driverService.updateDriver(driverId, dto);
    }

    @DeleteMapping("/{driverId}")
    @Operation(summary = "Delete a driver", description = "Deletes the driver with the given ID.")
    public void deleteDriver(@PathVariable long driverId) {
        driverService.deleteDriver(driverId);
    }

    @GetMapping("/{driverId}")
    @Operation(summary = "Find driver by ID", description = "Finds and returns the driver with the given ID.")
    public DriverDto findById(@PathVariable long driverId) {
        return new DriverDto(driverService.findById(driverId));
    }

    @PostMapping("/{driverId}/vehicle")
    @Operation(summary = "Add a vehicle to a driver", description = "Adds a vehicle to the driver with the given ID.")
    public void addVehicle(@PathVariable long driverId,
                           @RequestBody @Valid VehicleDto dto){
        driverService.addVehicle(driverId, dto);
    }

    @DeleteMapping("/{driverId}/vehicle/{vehicleId}")
    @Operation(summary = "Delete a vehicle from a driver", description = "Deletes the vehicle with the given ID from the driver with the given ID.")
    public void deleteVehicle(long driverId, long vehicleId){
        driverService.deleteVehicle(driverId, vehicleId);
    }

}
