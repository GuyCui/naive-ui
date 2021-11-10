package com.cmz.lightcore.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: light-core
 * @description: AOP切点
 * @author: 崔明志
 * @create: 2021-11-10 10:42
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 切点表达式
     */
    String pointcut() default "";
}
