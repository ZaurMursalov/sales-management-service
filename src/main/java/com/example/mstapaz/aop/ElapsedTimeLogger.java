package com.example.mstapaz.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ElapsedTimeLogger {

//    @Pointcut(value = "execution(* com.example.mstapaz.service.MattService.*(..))")
//    public void elapsedTimePc(){
//    }


    @SneakyThrows
    public void elapsedTimeLogger(ProceedingJoinPoint jp){
        long startDate=System.currentTimeMillis();
        jp.proceed();
        long endDate=System.currentTimeMillis();

        log.info("Elapsed time: {}",endDate-startDate);

    }

//    @Before(value = "elapsedTimePc()")
//    public void elapsedTimeLogger(JoinPoint joinPoint){
//        Arrays.stream(
//                joinPoint.getArgs()).forEach(arg->log.info("All methods : {}",arg));
//
//        log.info("Aop started");
//
//    }



}
