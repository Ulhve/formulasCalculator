package com.example.calculator.dto;

import com.example.calculator.model.MathFunction;

public record MathFunctionWithFormula(String name, MathFunction formula) {}
