package com.example.thread_study.web;

import com.example.thread_study.listener.ConsumerRedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lingwang
 * @date 2021/12/6 16:04
 */
@Configuration
public class RedisConsumer {

    @Autowired
    private ConsumerRedisListener listener;

    @Bean
    public void BeanOne(){
        System.out.println("BeanOne");
        listener.run();
    }

}
