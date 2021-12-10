package com.example.thread_study.web;

import com.example.thread_study.utils.Code;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}
