package ru.otus.spring.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* ru.otus.spring.service.Examiner33ServiceImpl.start(..))")
    public void timeTest(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start();

        joinPoint.proceed();

        watch.stop();
        System.out.println("Total time spent on the test: " + watch.getTotalTimeSeconds() + " second");
    }

}


