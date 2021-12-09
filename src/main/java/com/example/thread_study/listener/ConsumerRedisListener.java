package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
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


    @Override
    public void run(){
        int current = 0 ;
        //while循环-验证可以一直向redis发送消息
        while (current<100) {
            System.out.println("ConsumerRedisListener-run");
            //将redis队列写死
            redisTemplate.opsForList().leftPush(Code.REDISLIST,"消息发送:"+current);
            current++;
        }
    }

}
