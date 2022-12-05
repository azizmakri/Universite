package tn.esprit.aziz.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@Aspect
public class ArroundAspect {
    @Around("execution( * tn.esprit.aziz.Services.IEquipeServiceImp.getAllEquipe(..))")
    public List<Object> executionTime(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
	    List<Object> obj = new ArrayList<Object>(); // si le type de retour est une liste
		obj = (List<Object>) pjp.proceed();
       // Object obj = pjp.proceed();

        stopWatch.stop();

        String methodName = pjp.getSignature().getName();

        log.info("The runtime of the method ( "+ methodName + " ) = " + stopWatch.getTotalTimeMillis() + " milliseconds.");

        return obj;
    }
}
