package com.example.calculator.service;

import com.example.calculator.dto.MathFunctionWithExpression;

import java.util.List;

public interface FormulasParser {

    List<MathFunctionWithExpression> parseFormulas(List<String> formulas);

}
