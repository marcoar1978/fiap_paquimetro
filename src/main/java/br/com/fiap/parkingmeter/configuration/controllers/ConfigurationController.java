package br.com.fiap.parkingmeter.configuration.controllers;

import br.com.fiap.parkingmeter.configuration.services.ConfigurationService;
import br.com.fiap.parkingmeter.configuration.services.dto.ConfigurationDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Configuration", description = "API for configurations")
@RequestMapping("/configuration")
public class ConfigurationController {
    private ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @GetMapping
    @Operation(summary = "Get current configuration", description = "Retrieve the current system configuration.")
    public ConfigurationDto get() {
        return configurationService.getConfiguration();
    }

    @PutMapping
    @Operation(summary = "Update configuration", description = "Update the system configuration with new values.")
    public void updateConfiguration(@RequestBody @Valid ConfigurationDto dto) {
        configurationService.updateConfiguration(dto);
    }

}