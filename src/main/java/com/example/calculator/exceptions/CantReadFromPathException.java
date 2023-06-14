package com.example.calculator.exceptions;

public class CantReadFromPathException extends RuntimeException {
    public CantReadFromPathException(String path, Throwable cause) {
        super(String.format("can't read from path=%s", path), cause);
    }
}
