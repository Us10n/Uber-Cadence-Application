package by.stas.uca.registrar;

public interface WorkflowRegistrar {
    void register(String domainName, String taskListName, Class<?> workflowClass);
}
