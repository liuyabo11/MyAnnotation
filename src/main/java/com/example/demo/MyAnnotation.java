package com.example.demo;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

//这个注解就是表明该注解类能够作用的范围，也就是能够注解在哪，比如 类、方法、参数等。
@Target({ElementType.METHOD})
//这个注解是保留说明，也就是表明这个注解所注解的类能在哪里保留
@Retention(RetentionPolicy.RUNTIME)
//表明这个注解应该被 javadoc工具记录
@Documented
//表明这个注解应该被 javadoc工具记录
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface MyAnnotation {
    String value() ;
    //String log() default "";
}
