package com.example.thread_study.aop;

import java.lang.annotation.*;

/**
 * @author lingwang
 * @date 2021/12/14 15:14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogOne {
}
