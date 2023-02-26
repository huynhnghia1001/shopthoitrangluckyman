package com.DuAnTT_LuckyMan.Controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DuAnTT_LuckyMan.entity.Account;
import com.DuAnTT_LuckyMan.service.AccountService;
import com.DuAnTT_LuckyMan.service.MailService;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String tc() {
		return "redirect:/product/list";
	}
	
	@RequestMapping("lo")
	public String index() {
		return "layout/index1";
	}
	@RequestMapping("cate")
	public String category() {
		return "layout/_category";
	}
	@RequestMapping("pro")
	public String product() {
		return "layout/product";
	}
	
	@RequestMapping("/login")
	public String Login() {
		return "layout/login2";
	}
	
	@RequestMapping("/registration")
	public String Hello() {
		return "layout/registration";
	}
	
	@Autowired
	AccountService accser;
	
	@RequestMapping("/quenmk")
	public String quenk() {
		return "layout/quenmatkhau";
	}
	
	@RequestMapping("/quenmk/{username}")
	public String quenk1(Model model,@PathVariable("username") String username){
		model.addAttribute("username", username);
		return "layout/quenmatkhau1";
	}
	
	@RequestMapping("/quenmk/quen1")
	public String quenk2(@RequestParam("username") String username,
			@RequestParam("Password") String password,@RequestParam("ConfimPassword") String ConfimPassword){
		Account user = accser.findById(username);
		if(password.equals(ConfimPassword)) {
//			int pass = ThreadLocalRandom.current().nextInt(1000,9999);
//			String abc = String.valueOf(pass);
			user.setPassword(password);
			accser.save(user);
			return "redirect:/quenmk";
		}
		else {
			return "layout/quenmatkhau";
		}
		
	}
	
	@RequestMapping("/doimk")
	public String doimk() {
		return "layout/doimatkhau";
	}
	
	@RequestMapping("/gioithieu")
	public String gt() {
		return "layout/gioithieu";
	}
	@RequestMapping("/lienhe")
	public String lienhe() {
		return "layout/lienhe";
	}
	
	@Autowired
	MailService mail;
	
	@RequestMapping("/lienhe/send")
	public String lienhe1(Model m, @RequestParam("hoten") String hoten, 
			@RequestParam("email") String email, @RequestParam("mess") String mess) throws MessagingException{
		String nd = "họ tên: " + hoten + " Địa chỉ email: " + email + " Nội dung: " + mess;
		mail.sendEmaillh(nd);
		return "layout/lienhe";
	}
	
	@RequestMapping("/index")
	public String indexform() {
		return "layout/layout";
	}
	
	 @RequestMapping({"/admin", "/admin/home/index"})
	    public String admin() {
	    	return "redirect:/assets/admin/index.html";
	 }
	 
	 @RequestMapping("/capnhat")
		public String capnhat() {
			return "layout/capnhat";
	}
	 
	 
	 @RequestMapping("/a")
		public String a() {
			return "vnpay/index";
	}	
}
