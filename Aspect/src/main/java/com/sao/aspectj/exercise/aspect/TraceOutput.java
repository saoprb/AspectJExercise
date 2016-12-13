package com.sao.aspectj.exercise.aspect;

import org.aspectj.lang.annotation.*;

/**
 * Created by saoprb on 12/13/2016.
 */

@Aspect
public class TraceOutput {

    @Pointcut("execution(* *CircularQueueTest.*(..))")
    private void circularQueueMethodCallTest() {

    }

    @Pointcut("execution(* *CircularQueueTest.*(..) throws *ExceptionQueueEmpty)")
    private void circularQueueMethodCallTestThrowsEmpty() {

    }

    @Pointcut("execution(* *CircularQueueTest.*(..) throws *ExceptionQueueFull)")
    private void circularQueueMethodCallTestThrowsFull() {

    }

    @Before("circularQueueMethodCallTest()")
    public void beforeCircularQueueMethodCallTest() {
        System.out.println("before circularQueueMethodCallTest execution");
    }

    @After("circularQueueMethodCallTest() " +
            "|| circularQueueMethodCallTestThrowsEmpty()" +
            "|| circularQueueMethodCallTestThrowsFull()")
    public void afterCircularQueueMethodCallTest() {
        System.out.println("after circularQueueMethodCallTest execution");
    }

    @Pointcut("execution(* *CircularQueue.*(..))")
    public void circularQueueMethodCall() {

    }

    @Before("circularQueueMethodCall()")
    public void beforeCircularQueueMethodCall() {
        System.out.println("before circularQueueMethodCall execution");
    }

    @After("circularQueueMethodCall()")
    public void afterCircularQueueMethodCall() {
        System.out.println("after circularQueueMethodCall execution");
    }
}
