package com.example.thread_study.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/6 16:17
 */
@Service
public class ConsumerRedisListener extends Thread {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private String queueKey = "en";

    @Override
    public void run(){
        System.out.println("1");
       /* while (true) {
            System.out.println("1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }e
        }*/
    }

}
