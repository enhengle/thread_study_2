package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import javafx.scene.shape.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.server.ExportException;

/**
 * @author lingwang
 * @date 2021/12/6 16:17
 */
@Service
public class ConsumerRedisListener extends Thread {

    @Autowired
    private RedisService redisService;

    @Override
    public void run(){

        int current = 0 ;
        while (current<4){
            current++;
            try {
                redisService.inside(Code.REDISLIST,"message:"+current);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        while (true){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

}
