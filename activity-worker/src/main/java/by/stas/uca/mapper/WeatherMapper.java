package by.stas.uca.mapper;

import by.stas.uca.dto.WeatherDto;
import by.stas.uca.entity.Weather;
import org.mapstruct.Mapper;

import java.util.Map;

@Mapper
public interface WeatherMapper {

    WeatherDto mapToDto(Weather weather);

    WeatherDto mapToDto(Map<String, Object> map);

    Weather mapToEntity(WeatherDto weatherDto);
}
