package com.asyncServer.asyncServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class asyncController {

    @Autowired
    private populator pop;

    @GetMapping("/employees/{id}/name/{name}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") String employeeId,@PathVariable(value = "name") String name) throws ExecutionException, InterruptedException {
        CompletableFuture<Employee> emp = pop.produceEmployee(name, employeeId);

        System.out.println("Wating for the result");
        Employee emp2 = emp.get();
        System.out.println("I've got result. Now returning");
        return ResponseEntity.status(HttpStatus.OK).body(emp2);
    }

    //http://localhost:8080/ageCalculator?name=somename
    @GetMapping("/ageCalculator")
    public ResponseEntity<People> getAge(@RequestParam(name = "name") String name) throws ExecutionException, InterruptedException {
        CompletableFuture<People> people = pop.getAgeData(name);
        return ResponseEntity.status(HttpStatus.OK).body(people.get());
    }


}
