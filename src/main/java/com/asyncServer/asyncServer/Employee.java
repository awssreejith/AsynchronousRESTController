package com.asyncServer.asyncServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class Employee {
    public String getName() {
        return name;
    }
    //Just to check whether prototype bean returns same object or not
    final private String uuid = UUID.randomUUID().toString();

    public String getSalutation() {
        return Salutation;
    }


    //Just to check whether prototype bean returns same object or not
    public Employee() {
        System.out.println("Consturctor called");
    }

    private String name;

    public void setName(String name) {
        this.name = name+" = "+uuid;
    }

    public void setSalutation(String salutation) {
        Salutation = salutation+" of "+school.getSchoolName()+" school";
    }

    private String Salutation;

    @Autowired
    private School school;


}
