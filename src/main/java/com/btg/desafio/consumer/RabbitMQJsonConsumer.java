package com.btg.desafio.consumer;

import com.btg.desafio.entities.Orders;
import com.btg.desafio.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
    private OrderService orderService;

    @Autowired
    public RabbitMQJsonConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJsonMessage(Orders orders) {
        LOGGER.info("[CONSUMING FROM QUEUE] :: START");
        orderService.saveOrder(orders);
        LOGGER.info("[CONSUMING FROM QUEUE] :: END");
    }
}
