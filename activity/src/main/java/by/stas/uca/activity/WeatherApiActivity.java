package by.stas.uca.activity;

import by.stas.uca.dto.WeatherDto;
import com.uber.cadence.activity.ActivityMethod;

import java.util.Optional;

public interface WeatherApiActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 20, taskList = "testTaskList")
    Optional<WeatherDto> loadCurrentWeather(String cityName);
}
