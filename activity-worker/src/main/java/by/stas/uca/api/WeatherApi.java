package by.stas.uca.api;

import by.stas.uca.dto.WeatherDto;

import java.util.Optional;

public interface WeatherApi {
    Optional<WeatherDto> loadCurrentWeather(String cityName);
}
