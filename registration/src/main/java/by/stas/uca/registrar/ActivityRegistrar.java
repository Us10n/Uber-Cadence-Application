package by.stas.uca.registrar;

import java.util.List;

public interface ActivityRegistrar {
    void register(String domainName, String taskListName, List<Object> activities);
}
