package com.example.dubboprovider.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mengye
 * @desc rabbit配置
 * @date 2020/9/2 16:09
 */
@Configuration
@Slf4j
public class RabbitConfig {

    /**
     * 队列
     */
    private static final String queue="student_queue";

    /**
     * 交换机
     */
    private static final String exchange="student_exchange";

    private static final String routing_key="student_routing_key";

    @Bean
    public Queue testStudentQueue() {
        // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        //   return new Queue("TestDirectQueue",true,true,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        log.info("创建student队列");
        return new Queue(RabbitConstant.queue,true);
    }

    @Bean
    public DirectExchange testStudentExchange(){
        log.info("设置student交换机");
        return new DirectExchange(RabbitConstant.exchange,true,false);
    }

    @Bean
    public Binding bindingExchange(){
        log.info("设置student 队列与交换机 绑定");
       return BindingBuilder.bind(testStudentQueue()).to(testStudentExchange()).with(RabbitConstant.routing_key);
    }


}
