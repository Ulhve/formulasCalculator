package com.example.calculator;

import com.example.calculator.events.FormulasFileChangedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootCalculatorConsoleApplication implements CommandLineRunner {

    private final ApplicationEventPublisher applicationEventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCalculatorConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(args)
                .forEach(path -> {
                    applicationEventPublisher.publishEvent(new FormulasFileChangedEvent(this, path));
                });

    }

}
