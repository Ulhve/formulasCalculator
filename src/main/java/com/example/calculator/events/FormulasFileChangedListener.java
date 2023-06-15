package com.example.calculator.events;


import com.example.calculator.dto.MathFunctionWithFormula;

import java.util.List;

public interface FormulasFileChangedListener {

    List<MathFunctionWithFormula> getCurrentFormulas();
}
