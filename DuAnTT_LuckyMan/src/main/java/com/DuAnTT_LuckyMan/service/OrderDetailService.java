package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findAll();

	OrderDetail create(OrderDetail orderDetail);

	OrderDetail update(OrderDetail orderDetail);

	void delete(Integer id);






}	
