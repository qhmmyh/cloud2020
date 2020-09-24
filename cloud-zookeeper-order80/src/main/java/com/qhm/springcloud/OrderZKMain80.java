package com.qhm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderZKMain80.class, args);
	}

	
}
