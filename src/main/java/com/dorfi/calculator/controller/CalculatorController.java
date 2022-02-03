package com.dorfi.calculator.controller;

import com.dorfi.calculator.aspect.LogExecutionTime;
import com.dorfi.calculator.service.CalculatorService;
import com.dorfi.calculator.service.ICalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @LogExecutionTime
    @GetMapping("/result")
    public ResponseEntity<Integer> getResult() {
        return new ResponseEntity<>(service.getResult(), HttpStatus.OK);
    }

    @PostMapping(value = "/add/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> add(@PathVariable int value) {
        service.add(value);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/subtract/{value}")
    public ResponseEntity<Void> subtract(@PathVariable int value) {
        service.subtract(value);
        return ResponseEntity.ok().build();
    }

    @LogExecutionTime
    @PostMapping("/multiply/{value}")
    public ResponseEntity<Void> multiply(@PathVariable int value) {
        service.multiply(value);
        return ResponseEntity.ok().build();
    }

    @LogExecutionTime
    @PostMapping("/divide/{value}")
    public ResponseEntity<String> divide(@PathVariable int value) {
        service.divide(value);
        return ResponseEntity.ok().build();
    }

    @LogExecutionTime
    @PostMapping("/logarithm/{value}")
    public ResponseEntity<String> logarithm(@PathVariable int value) {
        service.logarithm(value);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reset")
    public ResponseEntity<Void> reset() {
        service.reset();
        return ResponseEntity.ok().build();
    }
}
