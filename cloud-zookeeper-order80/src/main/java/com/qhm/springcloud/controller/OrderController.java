package com.qhm.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value="order")
public class OrderController {

	private final static String PAYMENT_URL = "http://cloud-payment-service";
	
	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping(value="/consumer/zk")
	public String zk() {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
	}
	
}
