package com.asyncServer.asyncServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AsyncServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AsyncServerApplication.class, args);
	}

}
