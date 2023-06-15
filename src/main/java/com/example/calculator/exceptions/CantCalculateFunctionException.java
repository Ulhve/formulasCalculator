package com.example.calculator.exceptions;

public class CantCalculateFunctionException extends RuntimeException {
    public CantCalculateFunctionException(String name, Throwable cause) {
        super(String.format("can't calculate formula=%s", name), cause);
    }
}
