package by.stas.uca.registrar;

public interface ActivityRegistrar {
    void register(String domainName, String taskListName, Object... activities);
}
