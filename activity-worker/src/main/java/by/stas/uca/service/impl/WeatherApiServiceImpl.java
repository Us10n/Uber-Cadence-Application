package by.stas.uca.service.impl;

import by.stas.uca.api.WeatherApi;
import by.stas.uca.dto.WeatherDto;
import by.stas.uca.service.WeatherApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {

    private final WeatherApi weatherApi;

    @Override
    public Optional<WeatherDto> loadCurrentWeather(String cityName) {
        return weatherApi.loadCurrentWeather(cityName);
    }
}
