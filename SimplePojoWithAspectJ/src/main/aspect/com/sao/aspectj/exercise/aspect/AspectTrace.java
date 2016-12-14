package com.sao.aspectj.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by saoprb on 12/14/2016.
 */

@Aspect
public class AspectTrace {

    @Pointcut("execution(* *(..))")
    public void executionTrace() {

    }

    @Before("executionTrace()")
    public void beforeExecution(JoinPoint joinPoint) {
        System.out.println("beforeExecution");
    }

    @After("executionTrace()")
    public void afterExecution(JoinPoint joinPoint) {
        System.out.println("afterExecution");
    }
}
