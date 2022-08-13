package by.stas.uca.config;

import by.stas.uca.activity.WeatherApiActivity;
import by.stas.uca.activity.WeatherDbActivity;
import by.stas.uca.registrar.ActivityRegistrar;
import by.stas.uca.registrar.DomainRegistrar;
import by.stas.uca.registrar.impl.ActivityRegistrarImpl;
import by.stas.uca.registrar.impl.DomainRegistrarImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CadenceConfig {
    @Value("${cadence.domain:default}")
    private String domainName;

    @Value("${cadence.task-list:default}")
    private String taskList;

    @Bean
    public DomainRegistrar domainRegistrar() {
        return new DomainRegistrarImpl();
    }

    @Bean
    public ActivityRegistrar activityRegistrar() {
        return new ActivityRegistrarImpl();
    }


    @Bean
    public CommandLineRunner commandLineRunner(WeatherApiActivity weatherApiActivity,
                                               WeatherDbActivity weatherDbActivity,
                                               DomainRegistrar domainRegistration,
                                               ActivityRegistrar activityRegistration) {
        return args -> {
            domainRegistration.register(domainName);
            activityRegistration.register(domainName, taskList, weatherApiActivity, weatherDbActivity);
        };
    }
}
