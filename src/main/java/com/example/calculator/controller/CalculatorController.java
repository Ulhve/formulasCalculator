package com.example.calculator.controller;

import com.example.calculator.events.FormulasFileChangedListener;
import com.example.calculator.service.Calculator;
import com.example.calculator.service.OutputService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Component
@RequiredArgsConstructor
public class CalculatorController {

    private final Calculator calculator;
    private final OutputService outputService;
    private final FormulasFileChangedListener formulasFileChangedListener;

    public void CalculateFormulasForArguments(Map<String, Double> arguments){
        calculator.calculate(formulasFileChangedListener.getCurrentFormulas(), arguments)
                .stream()
                .forEach(result -> outputService.outputResult(result));
    }

}
