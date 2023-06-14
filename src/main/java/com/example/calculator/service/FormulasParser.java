package com.example.calculator.service;

import com.example.calculator.model.MathFunctionWithExpression;

import java.util.List;

public interface FormulasParser {

    List<MathFunctionWithExpression> parseFormulas(List<String> formulas);

}
