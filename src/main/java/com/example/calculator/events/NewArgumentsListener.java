package com.example.calculator.events;

import com.example.calculator.controller.CalculatorController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NewArgumentsListener {

    private final CalculatorController controller;

    @EventListener
    public void onFormulasFileChangedEvent(NewArgumentsEvent event){
        calculateFormulasForArguments(event.getArguments());
    }

    private void calculateFormulasForArguments(Map<String, Double> arguments){
        controller.CalculateFormulasForArguments(arguments);
    }
}
