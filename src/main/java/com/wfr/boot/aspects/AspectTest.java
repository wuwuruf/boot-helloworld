package com.wfr.boot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 环绕通知可以影响被切面方法的执行，这里我没试

@Component
@Aspect
@Order(1) // 若有多个切面可用order指定切面顺序，数字越小越先
public class AspectTest {

    // 抽取可重用切入点表达式
    @Pointcut("execution(public * com.wfr.boot.controller.ParameterTestController.*(..))")
    public void myPoint(){}

    @Before("myPoint()")
    public void beforeTest(JoinPoint joinPoint) {
        System.out.println("前置通知" + ",参数：" + Arrays.asList(joinPoint.getArgs()) + ",方法名：" + joinPoint.getSignature().getName());
    }

    @After("execution(public * com.wfr.boot.controller.ParameterTestController.*(..))")
    public void afterTest(JoinPoint joinPoint) {
        System.out.println("后置通知" + ",参数：" + Arrays.asList(joinPoint.getArgs()) + ",方法名：" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(public * com.wfr.boot.controller.ParameterTestController.*(..))", returning = "result")
    public void afterRunningTest(JoinPoint joinPoint, Object result) {
        System.out.println("返回通知" + ",参数：" + Arrays.asList(joinPoint.getArgs()) + ",方法名：" +
                joinPoint.getSignature().getName() + ",返回值：" + result);
    }

    @AfterThrowing(value = "execution(public * com.wfr.boot.controller.ParameterTestController.*(..))", throwing = "e")
    public void afterThrowingTest(JoinPoint joinPoint, Exception e) {
        System.out.println("异常通知" + ",参数：" + Arrays.asList(joinPoint.getArgs()) + ",方法名：" +
                joinPoint.getSignature().getName() + ",异常：" + e);
    }
}
