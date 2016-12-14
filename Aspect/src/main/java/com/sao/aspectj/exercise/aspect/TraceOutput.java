package com.sao.aspectj.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by saoprb on 12/13/2016.
 */

@Aspect
public class TraceOutput {

    @Pointcut("@annotation(traceAnnotation)")
    private void traceExecution(TraceAnnotation traceAnnotation) {

    }

    @Pointcut("execution(* *(..))")
    private void genericExecution() {

    }

    @Pointcut("execution(* *(..) throws *.*)")
    private void genericExecutionAndThrows() {

    }

    @Before("traceExecution(traceAnnotation) && genericExecution()")
    public void beforeTraceExecution(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        System.out.println("before traceExecution execution");
    }

    @Before("traceExecution(traceAnnotation) && genericExecution()")
    public void afterTraceExecution(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        System.out.println("after traceExecution execution");
    }

    @Before("traceExecution(traceAnnotation) && genericExecutionAndThrows()")
    public void beforeTraceExecutionWithThrow(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        System.out.println("before traceExecution execution");
    }

    @Before("traceExecution(traceAnnotation) && genericExecutionAndThrows()")
    public void afterTraceExecutionWithThrow(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        System.out.println("after traceExecution execution");
    }
}
