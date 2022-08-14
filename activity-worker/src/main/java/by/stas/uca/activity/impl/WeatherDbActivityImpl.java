package by.stas.uca.activity.impl;

import by.stas.uca.activity.WeatherDbActivity;
import by.stas.uca.dto.WeatherDto;
import by.stas.uca.service.WeatherDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeatherDbActivityImpl implements WeatherDbActivity {

    private final WeatherDbService weatherDbService;

    @Override
    public WeatherDto save(WeatherDto weatherDto) {
        return weatherDbService.save(weatherDto);
    }
}
