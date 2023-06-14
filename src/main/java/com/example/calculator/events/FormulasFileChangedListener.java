package com.example.calculator.events;


import com.example.calculator.dto.MathFunctionWithExpression;

import java.util.List;

public interface FormulasFileChangedListener {

    List<MathFunctionWithExpression> getCurrentFormulas();
}
