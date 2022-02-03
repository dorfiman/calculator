package com.dorfi.calculator.controller;

import com.dorfi.calculator.introduction.Validator;
import com.dorfi.calculator.introduction.ValidatorImpl;
import com.dorfi.calculator.model.Operation;
import com.dorfi.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdvancedCalculatorController {

    private final CalculatorService service;

    public AdvancedCalculatorController(CalculatorService service) {
        this.service = service;
    }

    @PostMapping
    public int calculate(Operation operation) {
        ((Validator) service).validate(operation);
        return service.calculate(operation);
    }
}
