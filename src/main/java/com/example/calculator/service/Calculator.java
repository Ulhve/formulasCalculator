package com.example.calculator.service;

import com.example.calculator.dto.MathFunctionWithExpression;
import com.example.calculator.dto.Result;

import java.util.List;
import java.util.Map;

public interface Calculator {

    List<Result> calculate(List<MathFunctionWithExpression> formulas, Map<String, Double> arguments);

}
