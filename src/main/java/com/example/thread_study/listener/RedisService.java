package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/9 11:41
 */
@Service
public class RedisService {

    @Autowired
    protected RedisTemplate<String,String> redisTemplate;

    public Object get(){
        return redisTemplate.opsForList().leftPop(Code.REDISLIST);
    }

}
