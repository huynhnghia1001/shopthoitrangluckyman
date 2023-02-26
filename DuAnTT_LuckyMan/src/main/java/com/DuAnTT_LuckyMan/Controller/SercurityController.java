package com.DuAnTT_LuckyMan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SercurityController {
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập ");
		return "layout/login2";
	}
	
	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "layout/login2";
	}
	
	@RequestMapping("/security/login/error")
	public String loginEror(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "layout/login2";
	}
	
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất!");
		return "layout/login2";
	}
	
	@RequestMapping("/security/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message", "Bạn đã đăng xuất!");
		return "layout/login2";
	}
	
	@RequestMapping("/security/registration/form")
	public String registration(Model model) {
		model.addAttribute("message", "Vui lòng nhập thông tin!");
		return "security/registration";
	}
	
}
