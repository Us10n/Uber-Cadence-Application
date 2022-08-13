package by.stas.uca.workflow.impl;

import by.stas.uca.activity.WeatherApiActivity;
import by.stas.uca.activity.WeatherDbActivity;
import by.stas.uca.dto.WeatherDto;
import by.stas.uca.workflow.WeatherWorkflow;
import com.uber.cadence.workflow.Workflow;

import java.util.Optional;

public class WeatherWorkflowImpl implements WeatherWorkflow {
    private final WeatherApiActivity weatherApiActivity;
    private final WeatherDbActivity weatherDbActivity;

    public WeatherWorkflowImpl() {
        this.weatherApiActivity = Workflow.newActivityStub(WeatherApiActivity.class);
        this.weatherDbActivity = Workflow.newActivityStub(WeatherDbActivity.class);
    }

    @Override
    public Optional<WeatherDto> start(String cityName) {
        Optional<WeatherDto> weatherDtoOptional = weatherApiActivity.loadCurrentWeather(cityName);
        Optional<WeatherDto> workflowResult = Optional.empty();
        if (weatherDtoOptional.isPresent()) {
            WeatherDto savedDto = weatherDbActivity.save(weatherDtoOptional.get());
            workflowResult = Optional.of(savedDto);
        }

        return workflowResult;
    }
}
