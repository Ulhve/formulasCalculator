package com.example.calculator.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class FormulasFileChangedEvent extends ApplicationEvent {

    private final String path;

    public FormulasFileChangedEvent(Object source, String path) {
        super(source);
        this.path = path;
    }

}
