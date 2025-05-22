package com.example.demo.modules.food.controllers;

import com.example.demo.modules.food.messaging.FoodBinding;
import com.example.demo.modules.food.messaging.FoodExchanges;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;




@RestController
@RequestMapping("/food")
public class FoodController {

    private final RabbitTemplate rabbitTemplate;

    public FoodController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public void sendTestOrder() {
        Map<String , String> map = new HashMap();
        map.put("orderId", "1");
        map.put("userId", "1");
        rabbitTemplate.convertAndSend(FoodExchanges.ORDER_EXCHANGE , FoodBinding.ORDER_ROUTING_KEY ,map );
        System.out.println("Send Test Order");
    }
}
