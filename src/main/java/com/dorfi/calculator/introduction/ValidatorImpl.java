package com.dorfi.calculator.introduction;

import com.dorfi.calculator.model.Operation;

public class ValidatorImpl implements Validator {

    @Override
    public boolean validate(Operation operation) {
        return operation.getInput1() > 0 && operation.getInput2() > 0;
    }

}
