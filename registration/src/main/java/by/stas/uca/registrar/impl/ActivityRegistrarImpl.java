package by.stas.uca.registrar.impl;

import by.stas.uca.registrar.ActivityRegistrar;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class ActivityRegistrarImpl implements ActivityRegistrar {
    @Override
    public void register(String domainName, String taskListName, Object... activities) {
        WorkflowClient workflowClient =
                WorkflowClient.newInstance(
                        new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                        WorkflowClientOptions.newBuilder().setDomain(domainName).build());

        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(taskListName);
        worker.registerActivitiesImplementations(activities);

        factory.start();
    }
}
