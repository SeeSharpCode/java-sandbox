package com.sandbox.springbootscheduledtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringBootScheduledTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootScheduledTasksApplication.class, args);
	}
}
