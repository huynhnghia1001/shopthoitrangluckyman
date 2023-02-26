package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {


	Order findById(Long id);
    
	List<Order> findByUsername(String username);

	public void deleteById(Long id);


	List<Order> findAll();

	Order create(JsonNode orderData);

	Order update(Order order);

	Order create1(Order order);



}	
