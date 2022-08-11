package by.stas.uca;

import by.stas.uca.registrar.impl.WorkflowRegistrarImpl;
import by.stas.uca.workflow.impl.WeatherWorkflowImpl;

public class WorkflowWorkerMain {
    public static void main(String[] args) {
        if(args.length < 2){
            throw new IllegalArgumentException("Invalid application parameters. Parameter signature is: domain name, task-list name.");
        }
        String domainName=args[0];
        String taskList=args[1];
        new WorkflowRegistrarImpl().register(domainName, taskList, WeatherWorkflowImpl.class);
    }
}
