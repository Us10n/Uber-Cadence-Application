package by.stas.uca.service.impl;

import by.stas.uca.dto.WeatherDto;
import by.stas.uca.entity.Weather;
import by.stas.uca.mapper.WeatherMapper;
import by.stas.uca.repository.WeatherRepository;
import by.stas.uca.service.WeatherDbService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class WeatherDbServiceImpl implements WeatherDbService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherDto save(WeatherDto weatherDto) {
        Weather entityToSave = weatherMapper.mapToEntity(weatherDto);
        entityToSave.setDate(LocalDateTime.now());
        weatherRepository.save(entityToSave);
        return weatherMapper.mapToDto(entityToSave);
    }
}
