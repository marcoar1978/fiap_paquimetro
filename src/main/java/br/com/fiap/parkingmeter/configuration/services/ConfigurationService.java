package br.com.fiap.parkingmeter.configuration.services;

import br.com.fiap.parkingmeter.configuration.services.dto.ConfigurationDto;

public interface ConfigurationService {

    ConfigurationDto getConfiguration();
    void updateConfiguration(ConfigurationDto dto);

}
