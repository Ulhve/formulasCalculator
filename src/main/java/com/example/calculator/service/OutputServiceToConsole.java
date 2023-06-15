package com.example.calculator.service;

import com.example.calculator.dto.Result;
import org.springframework.stereotype.Service;

@Service
public class OutputServiceToConsole implements OutputService {
    @Override
    public void outputResult(Result result) {
        System.out.print(String.format(" name= %1$s ",result.expression()));
        result.arguments().entrySet().stream()
                        .forEach(arg -> System.out.print(String.format(" %1$s = %2$f ", arg.getKey(), arg.getValue())));
        System.out.println(String.format(" calculated= %1$f ",result.calculated()));
    }
}
