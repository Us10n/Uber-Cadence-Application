package by.stas.uca.registrar.impl;

import by.stas.uca.registrar.WorkflowRegistrar;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class WorkflowRegistrarImpl implements WorkflowRegistrar {
    @Override
    public void register(String domainName, String taskListName, Class<?> workflowClass) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain(domainName).build());
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(taskListName);
        worker.registerWorkflowImplementationTypes(workflowClass);

        factory.start();
    }
}
