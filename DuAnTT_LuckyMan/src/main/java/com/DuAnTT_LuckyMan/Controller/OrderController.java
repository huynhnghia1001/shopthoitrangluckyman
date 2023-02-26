package com.DuAnTT_LuckyMan.Controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DuAnTT_LuckyMan.service.OrderService;



@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
    @RequestMapping("/order/checkout")
    public String checkout() {
    	return "cart/checkout";
    }
    
    @RequestMapping("/order/list")
    public String list(Model m, HttpServletRequest request) {
    	String username = request.getRemoteUser();
    	m.addAttribute("orders", orderService.findByUsername(username));
    	return "order/list";
    }
    
    @RequestMapping("/order/detail/{id}")
    public String detail(@PathVariable("id")Long id, Model m) {
    	m.addAttribute("order", orderService.findById(id));
    	return "order/detail";
    }
    
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id) {
    	 orderService.deleteById(id);
    	 return "redirect:/order/list";
    }
}
