package com.example.thread_study.web;

import com.example.thread_study.service.RedisService;
import com.example.thread_study.utils.Code;
import com.example.thread_study.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lingwang
 * @date 2021/12/6 16:04
 */
@RestController
public class RedisWeb {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "inside",method = RequestMethod.POST)
    public Response inside(@RequestParam(value = "queue",required = false,defaultValue = "") String queueList,
                            @RequestParam(value = "message",required = false,defaultValue = "-2") String message){
        if (queueList == null || queueList.trim().isEmpty()){
            queueList = Code.REDISLIST;
        }
        redisService.inside(queueList,message);
        return Response.ok(null);
    }

    @RequestMapping(value = "get",method = RequestMethod.POST)
    public Response getMessage(@RequestParam(value = "queue",required = false,defaultValue = "") String queueList){
        return Response.ok(redisService.getMessage(queueList));
    }

}
