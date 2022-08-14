package by.stas.uca.service;

import by.stas.uca.dto.WeatherDto;

public interface WeatherDbService {
    WeatherDto save(WeatherDto weatherDto);
}
