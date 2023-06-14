package com.example.calculator.service;

import com.example.calculator.model.MathFunctionWithExpression;
import com.example.calculator.model.Result;

import java.util.List;
import java.util.Map;

public interface Calculator {

    List<Result> calculate(List<MathFunctionWithExpression> formulas, Map<String, Double> arguments);

}
