package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/9 11:41
 */
@Service
public class RedisService {

    @Autowired
    protected RedisTemplate<String,String> redisTemplate;

    @Async("taskExecutor")
    public Object get(String queue) {
        System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        System.out.println(Thread.activeCount());

        try {
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
        return redisTemplate.opsForList().leftPop(queue);
    }


    public Object get2(String queue){
        System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        return redisTemplate.opsForList().leftPop(queue);
    }

    @Async("taskExecutor")
    public Object inside(String queue , String message) {
        Code.threads.put(Thread.currentThread().getName(),Thread.currentThread());
        System.out.println(Thread.currentThread().getName()+"  "+System.currentTimeMillis()+"  "+Code.threads.size()+"  "+Code.threads);
        try {
            Thread.sleep(100000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Code.threads.remove(Thread.currentThread().getName());
        return redisTemplate.opsForList().leftPush(queue,message);
    }

}
