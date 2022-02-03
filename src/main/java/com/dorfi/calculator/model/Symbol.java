package com.dorfi.calculator.model;

public enum Symbol {

    SUM {
        @Override
        public int calculate(int input1, int input2) {
            return input1 + input2;
        }
    }, SUBTRACT {
        @Override
        public int calculate(int input1, int input2) {
            return input1 - input2;
        }
    }, MULTIPLY {
        @Override
        public int calculate(int input1, int input2) {
            return input1 * input2;
        }
    }, DIVIDE {
        @Override
        public int calculate(int input1, int input2) {
            return input1 / input2;
        }
    };

    public abstract int calculate(int input1, int input2);
}
