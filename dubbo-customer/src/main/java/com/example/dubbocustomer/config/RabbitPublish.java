package com.example.dubbocustomer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mengye
 * @desc
 * @date 2020/9/2 16:48
 */
@Component
@RabbitListener(queues = RabbitConstant.queue)
@Slf4j
public class RabbitPublish {

    @RabbitHandler
    public void handlerStudentQueue(Map map){
      log.info("收到消息"+map.toString());
      log.info("开始消费,name:"+map.get("name")+" age:"+map.get("age"));

    }


}
