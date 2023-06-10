package com.example.ayumuadmin.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LoggingAspect
{
    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.ayumuadmin.controller..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
        stopWatch.start();
        String startTime = sdf.format(new Date());
        Object result = proceedingJoinPoint.proceed();
        String endTime = sdf.format(new Date());
        stopWatch.stop();

        //Log method execution time
        LOGGER.info("AYUMU["+startTime+","+endTime+"] Execution time of " + className + "." + methodName + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
}