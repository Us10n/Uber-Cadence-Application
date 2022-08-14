package by.stas.uca.service;

import by.stas.uca.dto.WeatherDto;

public interface WorkflowLauncherService {
    WeatherDto launch(String cityName);
}
