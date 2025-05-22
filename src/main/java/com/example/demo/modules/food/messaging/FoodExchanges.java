package com.example.demo.modules.food.messaging;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FoodExchanges {
    public static final String ORDER_EXCHANGE = "order.exchange";
    public static final String ORDER_DLX = "order.dlx";
   public static final String ORDER_EXCHANGE_QUALIFIER  = "ORDER_EXCHANGE_QUALIFIER";
    public static final String  ORDER_DLX_EXCHANGE_QUALIFIER= "ORDER_DLX_EXCHANGE_QUALIFIER";



    
    @Qualifier(ORDER_EXCHANGE_QUALIFIER)
    @Bean
    public DirectExchange orderExchange() {
        return new DirectExchange(ORDER_EXCHANGE);
    }

    @Qualifier(ORDER_DLX_EXCHANGE_QUALIFIER)
    @Bean
    public DirectExchange orderDLXExchange() {
        return new DirectExchange(ORDER_DLX);
    }

}
