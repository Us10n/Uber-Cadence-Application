package by.stas.uca.controller;

import by.stas.uca.dto.WeatherDto;
import by.stas.uca.service.WorkflowLauncherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workflow")
@RequiredArgsConstructor
public class WorkflowLauncherController {

    private final WorkflowLauncherService workflowLauncherService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WeatherDto weatherWorkflow(@RequestParam(name = "cityName", defaultValue = "London") String cityName) {
        return workflowLauncherService.launch(cityName);
    }
}
