package com.dorfi.calculator.service;

import com.dorfi.calculator.model.Operation;

public interface ICalculatorService {
    int getResult();

    void add(int value);

    void subtract(int value);

    void multiply(int value);

    void divide(int value);

    void logarithm(int value);

    void reset();

    int calculate(Operation operation);
}
