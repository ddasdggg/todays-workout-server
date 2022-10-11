package com.devchoi0926.todaysworkoutserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class TodaysWorkoutServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodaysWorkoutServerApplication.class, args);
    }

}
