package com.mayikt.ext;

import java.lang.annotation.*;

/**
 * @author liuyabo
 * @title ExtAsync
 * @create 2021/3/4 15:34
 */
//自定义注解，作用范围在方法和类上
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExtAsync {
}
