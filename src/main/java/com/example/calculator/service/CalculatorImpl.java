package com.example.calculator.service;

import com.example.calculator.dto.MathFunctionWithFormula;
import com.example.calculator.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorImpl implements Calculator {

    @Override
    public List<Result> calculate(List<MathFunctionWithFormula> formulas, Map<String, Double> arguments){
        return formulas.stream()
                .map(expr -> new Result(expr.name(), arguments, expr.formula().calculate(arguments)))
                .toList();
    }

}
