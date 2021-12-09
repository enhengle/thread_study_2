package com.example.thread_study.service;

import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/6 16:17
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void inside(String queueList , String message){
        System.out.println("ConsumerRedisListener-run");
        //机动redis队列
        redisTemplate.opsForList().leftPush(queueList,"消息发送:"+message);
    }

    public Object getMessage(String queueList){
        return redisTemplate.opsForList().leftPop(queueList);
    }

}
