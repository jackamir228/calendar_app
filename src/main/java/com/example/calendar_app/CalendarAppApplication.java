package com.example.calendar_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CalendarAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CalendarAppApplication.class, args);
    }

}
