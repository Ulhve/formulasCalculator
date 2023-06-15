package com.example.calculator.model;

import java.util.Map;

@FunctionalInterface
public interface MathFunction {

    Double calculate(Map<String, Double> arguments);

}
