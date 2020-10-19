package com.example.dubboprovider.controller;

import com.example.dubboprovider.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengye
 * @desc
 * @date 2020/9/1 14:12
 */
@RequestMapping("/rabbitmq")
@RestController
public class RabbitmqController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @GetMapping("/send201912")
    public String sendMessage(String name,Integer age){
        rabbitmqService.sendStudent(name,age);
        return "ok";
    }
}
