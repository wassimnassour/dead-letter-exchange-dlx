package com.example.demo.modules.food.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTestOrder() {
        String message = "Test order message!";
        rabbitTemplate.convertAndSend(
                FoodExchanges.ORDER_EXCHANGE,         // Exchange name
                FoodBinding.ORDER_ROUTING_KEY,        // Routing key
                message                               // Message body
        );
        System.out.println("✅ Sent: " + message);
    }
}
