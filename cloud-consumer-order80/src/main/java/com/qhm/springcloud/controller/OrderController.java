package com.qhm.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.qhm.springcloud.entities.CommonResult;
import com.qhm.springcloud.entities.Payment;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api
public class OrderController {
	
	private final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@Resource
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable(value="id") Long id) {
		log.info("==================查询数据");
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/consumer/payment/create")
	public CommonResult<Payment> create(Payment payment){
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create/", payment, CommonResult.class);
	}
	
}
