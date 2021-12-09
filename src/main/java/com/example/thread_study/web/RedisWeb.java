package com.example.thread_study.web;

import com.example.thread_study.listener.RedisService;
import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Object get(@RequestParam(value = "queue" , required = false , defaultValue = "")String queue){
        if (queue == null || queue.trim().isEmpty()){
            queue = Code.REDISLIST;
        }
        System.out.println("get");
        return String.valueOf(redisService.get2(queue));
    }

    @RequestMapping(value = "inside",method = RequestMethod.POST)
    public Object inside(@RequestParam(value = "queue" , required = false , defaultValue = "")String queue,
                         @RequestParam(value = "message" , required = false , defaultValue = "")String message) throws InterruptedException {
        if (queue == null || queue.trim().isEmpty()){
            queue = Code.REDISLIST;
        }
        System.out.println("inside");
        return redisService.inside(queue,message);
    }

}
