package com.example.calculator.model;

import java.util.Map;

public record Result(String expression, Map<String, Double> arguments, Double calculated) {}
