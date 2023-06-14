package com.example.calculator.service;

import com.example.calculator.model.Arguments;
import com.example.calculator.model.MathFunctionWithExpression;
import lombok.RequiredArgsConstructor;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FormulasParserViaExp4jImpl implements FormulasParser {

    @Override
    public List<MathFunctionWithExpression> parseFormulas(List<String> formulas) {

        Set<String> arguments = Arguments.getNames();

        return formulas.stream()
                .map(str -> {
                    Expression expr = new ExpressionBuilder(str).variables(arguments).build();
                    return new MathFunctionWithExpression(str, (args) -> expr.setVariables(args).evaluate());
                })
                .toList();
    }
}
