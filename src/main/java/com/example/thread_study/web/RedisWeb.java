package com.example.thread_study.web;

import com.example.thread_study.listener.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lingwang
 * @date 2021/12/9 11:40
 */
@RestController
public class RedisWeb {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "get",method = RequestMethod.POST)
    public Object get(){
        return String.valueOf(redisService.get());
    }

}
