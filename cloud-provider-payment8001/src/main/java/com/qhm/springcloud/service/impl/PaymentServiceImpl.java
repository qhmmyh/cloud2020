package com.qhm.springcloud.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qhm.springcloud.dao.PaymentDao;
import com.qhm.springcloud.entities.Payment;
import com.qhm.springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;
	
	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}

}
