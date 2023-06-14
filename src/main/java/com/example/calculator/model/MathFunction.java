package com.example.calculator.model;

import java.util.Map;

@FunctionalInterface
public interface MathFunction {

    double calculate(Map<String, Double> arguments);

}
