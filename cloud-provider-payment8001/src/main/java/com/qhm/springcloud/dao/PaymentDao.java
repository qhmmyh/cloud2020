package com.qhm.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qhm.springcloud.entities.Payment;

@Mapper
public interface PaymentDao {

	public int create(Payment payment);
	
	public Payment getPaymentById(@Param("id") Long id);
	
}
