package com.example.calculator.service;

import com.example.calculator.model.MathFunctionWithExpression;
import com.example.calculator.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

    @Override
    public List<Result> calculate(List<MathFunctionWithExpression> formulas, Map<String, Double> arguments){
        return formulas.stream()
                .map(expr -> new Result(expr.expression(), arguments, expr.function().calculate(arguments)))
                .toList();
    }

}
