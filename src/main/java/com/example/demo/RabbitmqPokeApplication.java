package com.example.demo;

import com.example.demo.modules.food.messaging.OrderProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqPokeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqPokeApplication.class, args);


	}

	@Bean
	public CommandLineRunner testRabbit(OrderProducer orderProducer) {
		return args -> {
			orderProducer.sendTestOrder();
		};
	}

}
