package com.yarm.service.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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

    public static String LOG_AOP_PERFIX = "DemoTestSpringAop";

/*
整个表达式可以分为五个部分：

 1、execution(): 表达式主体。

 2、第一个*号：表示返回类型，*号表示所有的类型。

 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。

 4、第二个*号：表示类名，*号表示所有的类。

 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
 @pointcut("execution(* com.sample.service.impl..*.*(..))")
*/

    // 以下注解方式
    // 注解方式定义切点
    @Pointcut("@annotation(com.yarm.service.annotation.MyAnnotation)")
    public void myAnnotationPointCut(){}

    // 以下是非注解方式
    // 这个com.yarm.service.demo包下的所有方法及方法参数
    @Pointcut("execution(* com.yarm.service.demo..*.*(..))")
    public void myPointCut(){}



    // 执行before
    @Before("myAnnotationPointCut()")
    public void myAnnotationBefore(){
        System.out.println(LOG_AOP_PERFIX + "执行before");
    }

    // 执行after
    @After("myAnnotationPointCut()")
    public void myAnnotationAfter(){
        System.out.println(LOG_AOP_PERFIX + "执行after");
    }

    // 执行Around
    @Around("myPointCut()")
    public void myAnnotationAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(LOG_AOP_PERFIX + "执行Around前");


        Map<String, Object> reqParam = getReqParam(joinPoint);

        if (reqParam.size() > 0) {
            log.info("入参:{}",JSONObject.toJSONString(reqParam));
        }

        // 让目标方法执行
        Object proceedResult = joinPoint.proceed(joinPoint.getArgs());
        log.info("出参:{}",JSONObject.toJSONString(proceedResult));

        System.out.println(LOG_AOP_PERFIX + "执行Around后");
    }


    // 注解执行AfterThrowing
    @AfterThrowing("myPointCut()")
    public void myAnnotationAfterThrowing(){
        System.out.println(LOG_AOP_PERFIX + "执行afterThrowing");
    }

    private static Map<String, Object> getReqParam(ProceedingJoinPoint joinPoint) {
        // 参数值
        Object[] args = joinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);

        Map<String, Object> paramMap = new HashMap<>(32);
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }

}