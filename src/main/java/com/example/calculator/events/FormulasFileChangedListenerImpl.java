package com.example.calculator.events;

import com.example.calculator.dto.MathFunctionWithExpression;
import com.example.calculator.service.InputService;
import com.example.calculator.service.FormulasParser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Getter
public class FormulasFileChangedListenerImpl implements FormulasFileChangedListener {

    private List<MathFunctionWithExpression> currentFormulas = new ArrayList<>();

    private final InputService fileReader;
    private final FormulasParser formulasParser;

    @EventListener
    public void onFormulasFileChangedEvent(FormulasFileChangedEvent event){
        SetFormulasFromFile(event.getPath());
    }

    private void SetFormulasFromFile(String path){
        currentFormulas = formulasParser.parseFormulas(fileReader.readStrings(path));
    }
}
