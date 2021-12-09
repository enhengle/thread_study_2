package com.example.thread_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadStudyApplication.class, args);
       /* //注册钩子线程，程序收到退出信号会将线程全部运行完全才会退出
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("---------------------");
            System.out.println("close");
            System.out.println("---------------------");
        }));*/
    }

}
