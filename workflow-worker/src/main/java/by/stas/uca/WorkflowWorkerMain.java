package by.stas.uca;

import by.stas.uca.registrar.impl.WorkflowRegistrarImpl;
import by.stas.uca.workflow.impl.WeatherWorkflowImpl;

public class WorkflowWorkerMain {

    private static final String DOMAIN_NAME="testDomainName";
    private static final String TASK_LIST="testTaskList";

    public static void main(String[] args) {
        new WorkflowRegistrarImpl().register(DOMAIN_NAME, TASK_LIST, WeatherWorkflowImpl.class);
    }
}
