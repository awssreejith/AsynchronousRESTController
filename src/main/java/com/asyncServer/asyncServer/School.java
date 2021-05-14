package com.asyncServer.asyncServer;

import org.springframework.stereotype.Component;

@Component
public class School {

    public String getSchoolName() {
        return schoolName;
    }

    private String schoolName;


    public School()
    {
        this.schoolName = "ManaBadi";
    }
}
