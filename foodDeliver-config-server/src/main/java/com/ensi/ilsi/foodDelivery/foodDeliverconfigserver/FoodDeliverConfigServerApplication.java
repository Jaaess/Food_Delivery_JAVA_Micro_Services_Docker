package com.ensi.ilsi.foodDelivery.foodDeliverconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class FoodDeliverConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliverConfigServerApplication.class, args);
	}
}
