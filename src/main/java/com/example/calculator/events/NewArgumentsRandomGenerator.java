package com.example.calculator.events;

import com.example.calculator.model.Arguments;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NewArgumentsRandomGenerator {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Scheduled(fixedRate = 5000)
    public void nextArgumentsValues() {
        Map<String, Double> newArgumentsValues = new HashMap<>();

        Arrays.stream(Arguments.values())
                        .forEach(arg -> {
                            newArgumentsValues.put(arg.getName(), Math.random()*Float.MAX_VALUE - Float.MAX_VALUE/2);
                        });

        applicationEventPublisher.publishEvent(new NewArgumentsEvent(this, newArgumentsValues));
    }

}
