package com.example.calculator.service;

import com.example.calculator.dto.MathFunctionWithFormula;

import java.util.List;

public interface FormulasParser {

    List<MathFunctionWithFormula> parseFormulas(String path);

}
