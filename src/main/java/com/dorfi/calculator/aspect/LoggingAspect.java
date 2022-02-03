package com.dorfi.calculator.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        LOGGER.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @Pointcut("execution(* com.dorfi.calculator.service.ICalculatorService.add(..))")
    public void add() {}

    @Pointcut("execution(* com.dorfi.calculator.service.ICalculatorService.subtract(..))")
    public void subtract() {}

    @After("add() || subtract()")
    public void after(JoinPoint joinPoint) {
        if ((Integer) joinPoint.getArgs()[0] > 100) {
            LOGGER.info("{} finished execution", joinPoint.getSignature().getName());
        }
    }

    @AfterThrowing("execution(* com.dorfi.calculator.service.CalculatorService.*(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        LOGGER.error("ERROR calling method {}", joinPoint.getSignature().getName());
    }

}
