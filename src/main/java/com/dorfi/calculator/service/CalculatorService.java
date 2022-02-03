package com.dorfi.calculator.service;

import com.dorfi.calculator.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    private int total = 0;

    @Override
    public int getResult() {
        return total;
    }

    @Override
    public void add(int value) {
        total+= value;
    }

    @Override
    public void subtract(int value) {
        total-= value;
    }

    @Override
    public void multiply(int value) {
        total*= value;
    }

    @Override
    public void divide(int value) {
//        if (value == 0) {
//            throw new Exception("Cannot divide by zero");
//        }
        total/= value;
    }

    @Override
    public void logarithm(int value) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        total = (int) Math.log(value);
    }

    @Override
    public void reset() {
        total = 0;
    }

    @Override
    public int calculate(Operation operation) {
        return operation.getSymbol().calculate(operation.getInput1(), operation.getInput2());
    }
}
