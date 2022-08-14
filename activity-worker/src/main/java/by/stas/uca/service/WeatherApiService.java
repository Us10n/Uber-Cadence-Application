package by.stas.uca.service;

import by.stas.uca.dto.WeatherDto;

import java.util.Optional;

public interface WeatherApiService {
    Optional<WeatherDto> loadCurrentWeather(String cityName);
}
