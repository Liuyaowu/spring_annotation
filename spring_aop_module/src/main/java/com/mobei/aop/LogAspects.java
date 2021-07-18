package com.mobei.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 日志切面类
 *
 * @Aspect: 标记LogAspects是一个切面类
 */
@Aspect
public class LogAspects {

    /**
     * 测试前置通知: 目标方法MathCalculator.div执行之前运行
     */
    @Before("execution(public int com.mobei.aop.MathCalculator.*(..))")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("业务方法名" + joinPoint.getSignature().getName());
        System.out.println("logStart--- 前置通知: {}");
    }

    /**
     * 测试后置通知: 目标方法MathCalculator.div运行结束之后运行,正常、异常结束都会执行
     */
    @After("execution(public int com.mobei.aop.MathCalculator.*(..))")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("logEnd--- 后置通知");
    }

    /**
     * 测试返回通知: 目标方法MathCalculator.div正常返回之后执行
     * value: 指定切点表达式
     * returning: 执行目标方法返回值参数名
     */
    @AfterReturning(
            value = "execution(public int com.mobei.aop.MathCalculator.*(..))",
            returning = "returnResult"
    )
    public void logReturn(Object returnResult) {
        System.out.println("logReturn--- 返回通知: 返回值{" + returnResult + "}");
    }

    /**
     * 测试异常通知: 目标方法MathCalculator.div执行出现异常后执行
     *
     * value: 切点表达式
     * exception: 接收异常的方法名
     */
    @AfterThrowing(value = "execution(public int com.mobei.aop.MathCalculator.*(..))",
        throwing = "exception"
    )
    public void logException(Exception exception) {
        System.out.println("logException--- 异常通知: {" + exception+ "}");
    }

}
