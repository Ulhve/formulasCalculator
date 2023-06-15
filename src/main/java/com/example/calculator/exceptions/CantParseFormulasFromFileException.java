package com.example.calculator.exceptions;

public class CantParseFormulasFromFileException extends RuntimeException {
    public CantParseFormulasFromFileException(String path, Throwable cause) {
        super(String.format("can't parse from path=%s", path), cause);
    }
}
