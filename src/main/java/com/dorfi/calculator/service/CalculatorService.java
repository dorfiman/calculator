package com.dorfi.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private int total = 0;

    public int getResult() {
        return total;
    }

    public void add(int value) {
        total+= value;
    }

    public void subtract(int value) {
        total-= value;
    }

    public void multiply(int value) {
        total*= value;
    }

    public void divide(int value) {
//        if (value == 0) {
//            throw new Exception("Cannot divide by zero");
//        }
        total/= value;
    }

    public void reset() {
        total = 0;
    }
}
