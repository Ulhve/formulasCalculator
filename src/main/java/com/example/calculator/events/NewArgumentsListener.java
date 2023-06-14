package com.example.calculator.events;

import com.example.calculator.controller.CalculatorController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewArgumentsListener {

    private final CalculatorController controller;

    @EventListener
    public void onFormulasFileChangedEvent(NewArgumentsEvent event){
        controller.CalculateFormulasForArguments(event.getArguments());
    }
}
