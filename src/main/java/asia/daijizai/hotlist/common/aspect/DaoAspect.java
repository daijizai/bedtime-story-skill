package asia.daijizai.hotlist.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/17 12:46
 * @description
 */

@Aspect
@Component
public class DaoAspect {

    @Around("execution(* asia.daijizai.hotlist.dao.*.*(..))")
    public Object logDaoExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("DAO method: " + joinPoint.getSignature().toShortString() + " executed in " + executionTime + "ms");

        return result;
    }
}