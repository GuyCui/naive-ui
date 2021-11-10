package com.cmz.lightcore.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: light-core
 * @description: Repository注解，用于标记 Dao 层的组件
 * @author: 崔明志
 * @create: 2021-11-10 10:32
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Repository {
}
