package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/6 16:17
 */
@Service
public class ConsumerRedisListener extends Thread {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private RedisService redisService;

    @Override
    public void run(){

        try {
            redisService.inside(Code.REDISLIST,"message:1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
