package com.example.thread_study.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lingwang
 * @date 2021/12/9 16:20
 */
@RestController
@RequestMapping("/pool")
public class PoolWeb {

    @RequestMapping(value = "close",method = RequestMethod.POST)
    public void getPoolMessage(){
        Thread thread = new Thread("taskExecutor--1");
        System.out.println(thread.getName()+"  "+Thread.currentThread());
        thread.interrupt();
    }

}
