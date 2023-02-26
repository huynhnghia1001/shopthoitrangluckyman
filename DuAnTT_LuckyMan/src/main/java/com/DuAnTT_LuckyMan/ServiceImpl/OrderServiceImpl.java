package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.OrderDAO;
import com.DuAnTT_LuckyMan.dao.OrderDetailDAO;
import com.DuAnTT_LuckyMan.entity.Order;
import com.DuAnTT_LuckyMan.entity.OrderDetail;
import com.DuAnTT_LuckyMan.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class OrderServiceImpl implements OrderService{
	
	   @Autowired
	    OrderDAO dao;
	    
	    @Autowired
	    OrderDetailDAO detailDao;

		@Override
		public Order create(JsonNode orderData) {
			ObjectMapper mp = new ObjectMapper();
			
			Order order = mp.convertValue(orderData, Order.class);
			dao.save(order);
			
			TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
			List<OrderDetail> details = mp.convertValue(orderData.get("orderDetails"), type)
					.stream().peek(d ->d.setOrder(order)).collect(Collectors.toList());
			detailDao.saveAll(details);
			return order;
		}

		public Order findById(Long id) {
			return dao.findById(id).get();
		}

		public List<Order> findByUsername(String username) {
			return dao.findByUsername(username);
		}

		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Order> findAll() {
			return dao.findAll();
		}

		

		@Override
		public Order update(Order order) {
			return dao.save(order);
		}

		@Override
		public Order create1(Order order) {
			return dao.save(order);
		}



		


}
