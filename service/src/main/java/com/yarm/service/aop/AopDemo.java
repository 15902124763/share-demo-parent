package com.yarm.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:17:41
 * Des:
 */
@Aspect
@Component
@Slf4j
public class AopDemo {

    @Pointcut("@annotation(com.yarm.service.annotation.MyAnnotation)")
    public void myAnnotationPointCut(){
        System.out.println("执行myAnnotationPointCut()");
    }
}