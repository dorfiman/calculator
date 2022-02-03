package com.dorfi.calculator.aspect;

import com.dorfi.calculator.introduction.Validator;
import com.dorfi.calculator.introduction.ValidatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidatorAspect {

//    @DeclareParents(value = "com.dorfi.calculator.service.CalculatorService", defaultImpl = ValidatorImpl.class)
//    public static Validator validator;
}
