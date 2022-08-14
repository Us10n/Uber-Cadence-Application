package by.stas.uca.activity.impl;

import by.stas.uca.activity.WeatherApiActivity;
import by.stas.uca.dto.WeatherDto;
import by.stas.uca.service.WeatherApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WeatherApiActivityImpl implements WeatherApiActivity {

    private final WeatherApiService weatherApiService;

    @Override
    public Optional<WeatherDto> loadCurrentWeather(String cityName) {
        return weatherApiService.loadCurrentWeather(cityName);
    }
}
