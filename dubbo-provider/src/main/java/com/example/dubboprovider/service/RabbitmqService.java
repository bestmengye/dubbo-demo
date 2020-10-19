package com.example.dubboprovider.service;

import com.example.dubboprovider.config.RabbitConfig;
import com.example.dubboprovider.config.RabbitConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mengye
 * @desc
 * @date 2020/9/2 16:21
 */
@Component
@Slf4j
public class RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendStudent(String name, Integer age) {
        Map map = new HashMap();
        map.put("name", name);
        map.put("age", age);
        rabbitTemplate.convertAndSend(RabbitConstant.exchange, RabbitConstant.routing_key, map);
        log.info("发送student成功:name:" + name + " age:" + age);
    }

}
