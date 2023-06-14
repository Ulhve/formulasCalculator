package com.example.calculator.service;

import com.example.calculator.exceptions.CantReadFromPathException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class InputServiceFromFileImpl implements InputService {

    @Override
    public List<String> readStrings(final String filePath){
        try(Stream<String> lines = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return lines.toList();
        } catch (IOException e) {
            throw new CantReadFromPathException(filePath, e);
        }
    }

}
