package br.com.fiap.parkingmeter.configuration.services;

import br.com.fiap.parkingmeter.configuration.domain.model.Configuration;
import br.com.fiap.parkingmeter.configuration.domain.repositories.ConfigurationRepository;
import br.com.fiap.parkingmeter.configuration.services.dto.ConfigurationDto;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService{

    private final ConfigurationRepository configurationRepository;

    public ConfigurationServiceImpl(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    @Override
    public ConfigurationDto getConfiguration() {
        Configuration configuration =  configurationRepository.findTopByOrderByIdDesc();
        return new ConfigurationDto(configuration.getRatePerHour(),
                configuration.getMinimumTime(), configuration.getCurrency());
    }

    @Override
    public void updateConfiguration(ConfigurationDto dto) {
        Configuration configuration =  configurationRepository.findTopByOrderByIdDesc();

        configuration.setCurrency(dto.getCurrency());
        configuration.setMinimumTime(dto.getMinimumTime());
        configuration.setRatePerHour(dto.getRatePerHour());

        configurationRepository.save(configuration);
    }
}
