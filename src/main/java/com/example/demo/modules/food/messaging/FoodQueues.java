package com.example.demo.modules.food.messaging;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.demo.modules.food.messaging.FoodExchanges.ORDER_DLX;


@Configuration
public class FoodQueues {
    public static final String ORDER_QUEUE = "order.queue";
    public static final String ORDER_DLQ = "order.dlq";
    public static final String ORDER_DLQ_ROUTING_KEY = "order.dlq.key"; // Updated to match FoodBinding
    public static final String OrderQueueQualifierName = "OrderQueueQualifierName";
    public static final String OrderDlqQueueQualifier = "OrderDlqQueueQualifier";


    @Qualifier(OrderQueueQualifierName)
    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE, true, false, false,
            java.util.Map.of(
                "x-dead-letter-exchange", ORDER_DLX,
                "x-dead-letter-routing-key", ORDER_DLQ_ROUTING_KEY
            ));
    }


    @Qualifier(OrderDlqQueueQualifier)
    @Bean
    public Queue orderDlqQueue() {
        return new Queue(ORDER_DLQ, true);
    }
}
