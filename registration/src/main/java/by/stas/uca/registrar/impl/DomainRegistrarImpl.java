package by.stas.uca.registrar.impl;

import by.stas.uca.registrar.DomainRegistrar;
import com.uber.cadence.RegisterDomainRequest;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.apache.thrift.TException;

public class DomainRegistrarImpl implements DomainRegistrar {
    private static final Integer RETENTION_PERIOD = 1;

    @Override
    public void register(String domainName) {
        IWorkflowService cadenceService = new WorkflowServiceTChannel(ClientOptions.defaultInstance());
        RegisterDomainRequest request = new RegisterDomainRequest();
        request.setName(domainName);
        request.setWorkflowExecutionRetentionPeriodInDays(RETENTION_PERIOD);

        try {
            cadenceService.RegisterDomain(request);
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
