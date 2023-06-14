package com.example.calculator.dto;

import com.example.calculator.model.MathFunction;

public record MathFunctionWithExpression(String expression, MathFunction function) {}
