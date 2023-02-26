package com.DuAnTT_LuckyMan.Rest.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DuAnTT_LuckyMan.entity.Account;
import com.DuAnTT_LuckyMan.entity.Order;
import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
     @Autowired
     OrderService orderService;
     
     @PostMapping()
     public Order create(@RequestBody JsonNode orderData) {
    	 return orderService.create(orderData);
     }
     
     @GetMapping
 	 public List<Order> getAll() {
 		return orderService.findAll();
 	 }
     
 	 @PutMapping("{id}")
 	 public Order update(@PathVariable("id") Long id,@RequestBody Order Order) {
 		return orderService.update(Order);
 	 }
 	 @DeleteMapping("{id}")
 	 public void delete(@PathVariable("id") Long id) {
 		orderService.deleteById(id);
 	 }
 	 @PostMapping("create")
	 public Order create1(@RequestBody Order Order) {
		return orderService.create1(Order);
	 }
 	@PostMapping("trangthai")
	 public Order trangthai(@RequestBody Order Order) {
		return orderService.update(Order);
	 }
}
