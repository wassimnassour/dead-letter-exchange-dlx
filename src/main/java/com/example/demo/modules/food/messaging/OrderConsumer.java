package com.example.demo.modules.food.messaging;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.Map;

@Component
public class OrderConsumer {

    @RabbitListener(queues = FoodQueues.ORDER_QUEUE)
    public void receiveOrder(Map<String , String> payload , Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("📥 Received from order.queue: " + message);
        channel.basicReject(deliveryTag, false);
    }

     @RabbitListener(queues = FoodQueues.ORDER_DLQ)
     public void receiveOrderDlq(String message) {
         System.out.println("Hello i'm from order.queue: " + message);
     }
}
