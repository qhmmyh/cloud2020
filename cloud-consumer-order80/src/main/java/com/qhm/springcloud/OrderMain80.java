package com.qhm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.qhm.ribbon.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE", configuration=MySelfRule.class)
public class OrderMain80 {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderMain80.class, args);
	}

	
}
