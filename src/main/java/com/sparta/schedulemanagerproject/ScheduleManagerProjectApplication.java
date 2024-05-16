package com.sparta.schedulemanagerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ScheduleManagerProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleManagerProjectApplication.class, args);
    }

}
