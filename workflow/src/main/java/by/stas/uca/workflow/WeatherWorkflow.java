package by.stas.uca.workflow;

import by.stas.uca.dto.WeatherDto;
import com.uber.cadence.workflow.WorkflowMethod;

import java.util.Optional;

public interface WeatherWorkflow {
    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 20, taskList = "testTaskList")
    Optional<WeatherDto> start(String cityName);
}
