package com.example.thread_study.listener;

import com.example.thread_study.utils.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author lingwang
 * @date 2021/12/6 16:17
 */
@Service
public class ConsumerRedisListener extends Thread {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void run(){
        int current = 0 ;
        //while循环-验证可以一直读取redis的信息
        while (true) {
            //将redis队列写死
            String result = redisTemplate.opsForList().leftPop(Code.REDISLIST);
            System.out.println(result);
            //若消息获取为空，即弹出
            if (result==null){
                break;
            }
            current++;
        }
    }

}
