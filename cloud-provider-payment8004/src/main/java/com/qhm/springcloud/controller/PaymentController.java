package com.qhm.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.UUID;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value="payment")
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping(value="/payment/zk")
	public String paymentzk() {
		return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
	}
	
}
