package com.example.thread_study.web;

import com.example.thread_study.listener.ConsumerRedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lingwang
 * @date 2021/12/6 16:04
 */
@Component
public class RedisConsumer implements ApplicationRunner {

    @Autowired
    private ConsumerRedisListener listener;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception{
        System.out.println("BeanOne");
        listener.run();
    }

}
