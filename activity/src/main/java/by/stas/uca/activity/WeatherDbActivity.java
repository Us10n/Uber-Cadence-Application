package by.stas.uca.activity;

import by.stas.uca.dto.WeatherDto;
import com.uber.cadence.activity.ActivityMethod;

public interface WeatherDbActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 20, taskList = "testTaskList")
    WeatherDto save(WeatherDto weatherDto);
}
