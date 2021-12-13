package com.example.thread_study.web;

import com.example.thread_study.utils.Code;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;


/**
 * @author lingwang
 * @date 2021/12/9 16:20
 */
@RestController
@RequestMapping("/pool")
public class PoolWeb {

    @RequestMapping(value = "close",method = RequestMethod.POST)
    public void getPoolMessage(@RequestParam("current")String current){
       Code.threads.get(current).interrupt();
    }
    @RequestMapping(value = "get",method = RequestMethod.POST)
    public Object get(){
        System.out.println(Code.threads);
        System.out.println(Code.threads.toString());
        return Code.threads;
    }

    @RequestMapping(value = "getAll" , method = RequestMethod.POST)
    @Async("taskExecutor")
    public Future<Object> getAll(){
        System.out.println(Thread.currentThread());
        Thread current = Thread.currentThread();
        System.out.println(current.getThreadGroup().activeCount());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("threadGroup:");
        System.out.println(threadGroup);
        System.out.println("parent:"+threadGroup.getParent());
        Thread[] isThread = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(isThread);
        for (Thread thread : isThread){
            System.out.println(thread.getId()+"  "+thread.getName()+"  "+thread.getState());
        }
        return new AsyncResult<>(Thread.currentThread().getThreadGroup());
    }

    @RequestMapping(value = "closeById" , method = RequestMethod.POST)
    @Async
    public void closeById(@RequestParam(value = "id")int id){
        Thread currentThread = Thread.currentThread();
        ThreadGroup currentGroup = currentThread.getThreadGroup();
        int count = currentGroup.activeCount();
        Thread[] threads = new Thread[count];
        currentGroup.enumerate(threads);
        for (Thread thread : threads){
            if (thread.getId() == id){
                thread.interrupt();
                System.out.println("id:"+thread.getId()+";name:"+thread.getName()+"。已发送停止信号");
                return;
            }
        }
        System.out.println("未找到该id");
    }
}
