package com.example.calculator.events;


import com.example.calculator.model.MathFunctionWithExpression;

import java.util.List;

public interface FormulasFileChangedListener {

    List<MathFunctionWithExpression> getCurrentFormulas();
}
