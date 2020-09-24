package com.qhm.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qhm.springcloud.entities.CommonResult;
import com.qhm.springcloud.entities.Payment;
import com.qhm.springcloud.service.PaymentService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value="Payment")
public class PaymentController {

	@Resource
	private PaymentService paymentService;
	
	@Value("${server.port}")
	private String servicePort;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value="/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("**********插入结果：" + result);
		if(result > 0) {
			return new CommonResult(200, "插入数据成功" + servicePort, result);
		} else {
			return new CommonResult(444, "失败", null);
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value="/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("**********查询结果：" + payment);
		if(payment != null) {
			return new CommonResult(200, "查询数据成功" + servicePort, payment);
		} else {
			return new CommonResult(444, "没有对应记录，查询ID：" + id);
		}
	}
	
}
