package com.example.thread_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author lingwang
 * @date 2021/12/9 14:35
 */
@Configuration
@EnableAsync
public class TaskPoolConfig {
    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        taskExecutor.setCorePoolSize(1);
        //设置最大线程数
        taskExecutor.setMaxPoolSize(2);
        //配置队列大小
        taskExecutor.setQueueCapacity(200);
        //设置线程活跃时间
        taskExecutor.setKeepAliveSeconds(60);
        //设置默认线程名称
        taskExecutor.setThreadNamePrefix("taskExecutor--");
        //等待所有业务结束再关闭线程
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        //停止程序前的等待时间
        taskExecutor.setAwaitTerminationSeconds(60);
        //执行初始化
        taskExecutor.initialize();
        return taskExecutor;
    }
}
