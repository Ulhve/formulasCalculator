package com.example.calculator.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Map;

@Getter
public class NewArgumentsEvent extends ApplicationEvent {

    private final Map<String, Double> arguments;

    public NewArgumentsEvent(Object source, Map<String, Double> arguments) {
        super(source);
        this.arguments = arguments;
    }

}
