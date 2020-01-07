package com.example.aopweb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

    @After(value = "@annotation(com.example.aopweb.aspect.OutInfo)")
//    @After(value = "execution(* com.example.aopweb.base.StudentInterfaceImpl.*(..))")
//    @After(value = "execution(* com.example.aopweb.aspect.StudentInterface.*(..))")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("执行" +joinPoint.getSignature().getName() + "后执行！！！");
    }
}
