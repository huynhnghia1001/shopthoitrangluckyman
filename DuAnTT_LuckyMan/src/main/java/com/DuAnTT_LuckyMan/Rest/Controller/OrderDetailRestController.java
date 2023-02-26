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

import com.DuAnTT_LuckyMan.entity.OrderDetail;
import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.service.OrderDetailService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetail")
public class OrderDetailRestController {
     @Autowired
     OrderDetailService orderdetailService;
     
    
     @GetMapping
 	 public List<OrderDetail> getAll() {
 		return orderdetailService.findAll();
 	 }
     @PostMapping
 	 public OrderDetail create(@RequestBody OrderDetail OrderDetail) {
 		return orderdetailService.create(OrderDetail);
 	 }
 	 @PutMapping("{id}")
 	 public OrderDetail update(@PathVariable("id") Integer id,@RequestBody OrderDetail OrderDetail) {
 		return orderdetailService.update(OrderDetail);
 	 }
 	 @DeleteMapping("{id}")
 	 public void delete(@PathVariable("id") Integer id) {
 		orderdetailService.delete(id);
 	}
}
