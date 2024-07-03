package br.com.fiap.parkingmeter.driver.application.services.dto;

import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class VehicleDto {

    private String model;
    private String licensePlate;

    public VehicleDto(Vehicle vehicle) {
        this.model = vehicle.getModel();
        this.licensePlate = vehicle.getLicensePlate();
    }

    public static List<VehicleDto> toList(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDto::new).toList();
    }

}
