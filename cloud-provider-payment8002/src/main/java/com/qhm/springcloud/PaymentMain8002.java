package com.qhm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PaymentMain8002.class, args);
	}

	
}
