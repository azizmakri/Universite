package tn.esprit.aziz.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution( * tn.esprit.aziz.Services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("in method "+joinPoint.getSignature().getName());
    }

}
