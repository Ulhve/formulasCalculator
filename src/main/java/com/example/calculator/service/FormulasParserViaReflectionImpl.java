package com.example.calculator.service;

import com.example.calculator.dto.MathFunctionWithFormula;
import com.example.calculator.exceptions.CantParseFormulasFromFileException;
import com.example.calculator.exceptions.CantCalculateFunctionException;
import com.example.calculator.service.utils.ReflectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FormulasParserViaReflectionImpl implements FormulasParser {

    @Override
    public List<MathFunctionWithFormula> parseFormulas(String textPath) {
        Path path = Paths.get(textPath);
        try {
            ReflectionUtils.compileSourceFiles(path);
            return getFunctionsFromCompiledClass(path);
        } catch (ClassNotFoundException | IOException | InstantiationException
                | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new CantParseFormulasFromFileException(textPath, e);
        }

    }

    private List<MathFunctionWithFormula> getFunctionsFromCompiledClass(Path path)
            throws ClassNotFoundException , MalformedURLException, InstantiationException
            , IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        List<MathFunctionWithFormula> mathFunctionWithExpressions = new ArrayList<>();
        Class clazz = ReflectionUtils.getCompiledClass(path);
        Object classInstance = clazz.getDeclaredConstructor().newInstance();
        Arrays.stream(clazz.getDeclaredMethods())
                .forEach(method -> mathFunctionWithExpressions.add(createFunction(classInstance, method)));
        return mathFunctionWithExpressions;
    }

    private MathFunctionWithFormula createFunction(Object classInstance, Method method) {
        return new MathFunctionWithFormula(method.getName(), (args) -> {
            try {
                return (Double) method.invoke(classInstance, mapArgumentsForFunction(method, args));
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new CantCalculateFunctionException(method.getName(), e);
            }
        });
    }

    private Object[] mapArgumentsForFunction(Method method, Map<String, Double> arguments) {
        return Arrays.stream(method.getParameters())
                .collect(LinkedHashMap::new, (m, i)->m.put(i.getName(), arguments.get(i.getName())), Map::putAll)
                .values().toArray(Object[]::new);
    }

}
