package br.com.fiap.parkingmeter.driver.application.services.dto;

import br.com.fiap.parkingmeter.driver.domain.model.Vehicle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class VehicleDto {

    @NotBlank(message = "Model is mandatory")
    @Size(max = 50, message = "Model should not exceed 50 characters")
    private String model;

    @NotBlank(message = "License Plate is mandatory")
    @Pattern(regexp = "^[A-Z]{3}\\d{4}$", message = "License Plate should be in the format 'ABC1234'")
    private String licensePlate;

    public VehicleDto(Vehicle vehicle) {
        this.model = vehicle.getModel();
        this.licensePlate = vehicle.getLicensePlate();
    }

    public static List<VehicleDto> toList(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDto::new).toList();
    }

}
