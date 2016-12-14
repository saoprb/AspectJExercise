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

    @Before("traceExecution(traceAnnotation) && genericExecution()")
    public void beforeTraceExecution(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        logOutput(joinPoint, "beforeTraceExecution");
    }

    @Before("traceExecution(traceAnnotation) && genericExecution()")
    public void afterTraceExecution(JoinPoint joinPoint, TraceAnnotation traceAnnotation) {
        logOutput(joinPoint, "afterTraceExecution");
    }

    private void logOutput(JoinPoint joinPoint, String methodName) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object arg : joinPoint.getArgs()) {
            stringBuffer.append(arg.toString()).append(", ");
        }
        String trimmed = stringBuffer.toString();
        trimmed = trimmed.length() > 0 ? trimmed.substring(0, trimmed.lastIndexOf(", ")) : "nil";
        System.out.format("%s: [%s] %s execution%n", joinPoint.toString(), trimmed, methodName);
    }
}
