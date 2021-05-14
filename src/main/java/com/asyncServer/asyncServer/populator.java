package com.asyncServer.asyncServer;

import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
public class populator {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Configurator configurator;

    @Autowired
    private RestTemplate restTemplate;


    @Async
    public CompletableFuture<Employee> produceEmployee(String name, String id)
    {
        //Employee emp =  this.getEmployee();

        Employee emp = configurator.getEmployeeBean();
        emp.setName(name);
        String threadName = Thread.currentThread().getName()+" - "+Thread.currentThread().getThreadGroup();
        emp.setSalutation("Hell00 "+name +"- "+emp.hashCode()+" - "+threadName);
        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            System.out.println("Exception caught");
        }
        return CompletableFuture.completedFuture(emp);
    }

    @Async
    public CompletableFuture<People> getAgeData(String name)
    {
        String uri = String.format("https://api.agify.io/?name=%s",name);
        People people = null;
        try
        {
            people = restTemplate.getForObject(uri,People.class);
        }
        catch(HttpClientErrorException | HttpServerErrorException hex)
        {
            System.out.println("Exception:- "+ hex);
        }
        catch(RestClientException rex)
        {
            System.out.println("Exception:- "+ rex);
        }
        return CompletableFuture.completedFuture(people);
    }

    //Not using as of now
    @Lookup
    public Employee getEmployee() {
        return null;
    }

}
