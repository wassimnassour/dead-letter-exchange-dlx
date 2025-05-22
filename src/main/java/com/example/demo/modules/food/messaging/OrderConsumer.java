package com.example.demo.modules.food.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @RabbitListener(queues = FoodQueues.ORDER_QUEUE)
    public void receiveOrder(String message) {
        System.out.println("📥 Received from order.queue: " + message);
    }
}
