package com.example.eventschedulerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EventSchedulerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventSchedulerServerApplication.class, args);
    }

}
