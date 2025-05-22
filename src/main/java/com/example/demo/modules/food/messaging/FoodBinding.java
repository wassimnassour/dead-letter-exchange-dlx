package com.example.demo.modules.food.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.demo.modules.food.messaging.FoodExchanges.ORDER_DLX_EXCHANGE_QUALIFIER;
import static com.example.demo.modules.food.messaging.FoodQueues.OrderDlqQueueQualifier;

@Configuration
public class FoodBinding {

    public static final String ORDER_ROUTING_KEY = "order.key";
    public static final String ORDER_DLQ_ROUTING_KEY = "order.dlq.key";

    @Bean
    public Binding orderBinding(@Qualifier(FoodQueues.OrderQueueQualifierName) Queue orderQueue, @Qualifier(FoodExchanges.ORDER_EXCHANGE_QUALIFIER) DirectExchange orderExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(orderExchange)
                .with(ORDER_ROUTING_KEY);
    }


    @Bean
    public Binding orderDLQBinding(@Qualifier(OrderDlqQueueQualifier) Queue orderDLQ, @Qualifier(ORDER_DLX_EXCHANGE_QUALIFIER) DirectExchange orderDLX) {
        return BindingBuilder
                .bind(orderDLQ)
                .to(orderDLX)
                .with(ORDER_DLQ_ROUTING_KEY);
    }
}
