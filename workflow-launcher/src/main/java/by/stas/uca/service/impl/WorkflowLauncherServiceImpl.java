package by.stas.uca.service.impl;

import by.stas.uca.dto.WeatherDto;
import by.stas.uca.exception.WorkflowEmptyResult;
import by.stas.uca.service.WorkflowLauncherService;
import by.stas.uca.workflow.WeatherWorkflow;
import com.uber.cadence.client.WorkflowClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkflowLauncherServiceImpl implements WorkflowLauncherService {

    private final WorkflowClient client;

    @Override
    public WeatherDto launch(String cityName) {
        WeatherWorkflow workflow = client.newWorkflowStub(WeatherWorkflow.class);
        WeatherDto weatherDto = workflow.start(cityName).orElseThrow(WorkflowEmptyResult::new);
        return weatherDto;
    }
}
