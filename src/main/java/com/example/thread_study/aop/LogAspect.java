package com.example.thread_study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author lingwang
 * @date 2021/12/14 15:09
 */
@Aspect
@Component
public class LogAspect {
    private final static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogOne)")
    public Object addAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        Object[] args = joinPoint.getArgs();
        return result;

    }


}
