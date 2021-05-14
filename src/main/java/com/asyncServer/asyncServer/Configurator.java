package com.asyncServer.asyncServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@Configuration
public class Configurator {


    @Bean
    @Scope("prototype")
    public Employee getEmployeeBean()
    {
        return new Employee();
    }

    @Bean
    public Executor getExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(60);
        executor.setThreadGroupName("MyThreadPool - ");
        executor.initialize();
        return executor;

    }

    @Bean
    @Scope("prototype")
    public People getPeople()
    {
        return new People();
    }

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
