package br.com.fiap.parkingmeter.driver.api.controllers;

import br.com.fiap.parkingmeter.driver.application.services.DriverService;
import br.com.fiap.parkingmeter.driver.application.services.dto.DriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.SaveDriverDto;
import br.com.fiap.parkingmeter.driver.application.services.dto.VehicleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public long createDriver(@RequestBody SaveDriverDto dto) {
        return driverService.createDriver(dto);
    }

    @PutMapping("/{driverId}")
    public void updateDriver(@PathVariable long driverId,
                             @RequestBody SaveDriverDto dto) {
        driverService.updateDriver(driverId, dto);
    }

    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable long driverId) {
        driverService.deleteDriver(driverId);
    }

    @GetMapping("/{driverId}")
    public DriverDto findById(@PathVariable long driverId) {
        return new DriverDto(driverService.findById(driverId));
    }

    @PostMapping("/{driverId}/vehicle")
    public void addVehicle(@PathVariable long driverId,
                           @RequestBody VehicleDto dto){
        driverService.addVehicle(driverId, dto);
    }

    @DeleteMapping("/{driverId}/vehicle/{vehicleId}")
    public void deleteVehicle(long driverId, long vehicleId){
        driverService.deleteVehicle(driverId, vehicleId);
    }

}
