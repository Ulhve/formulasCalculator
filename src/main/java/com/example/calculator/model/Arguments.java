package com.example.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum Arguments {
    ARG_0("arg0"),
    ARG_1("arg1");

    private String name;

    public static Set<String> getNames(){
        return Arrays.stream(Arguments.values())
                .map(arg -> arg.getName())
                .collect(Collectors.toSet());
    }
}
