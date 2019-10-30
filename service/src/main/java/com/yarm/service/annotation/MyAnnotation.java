package com.yarm.service.annotation;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/30
 * Time:17:59
 * Des:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    String name() default "";
}