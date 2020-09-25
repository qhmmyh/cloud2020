package com.qhm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainCs80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderMainCs80.class, args);
	}

	
}
