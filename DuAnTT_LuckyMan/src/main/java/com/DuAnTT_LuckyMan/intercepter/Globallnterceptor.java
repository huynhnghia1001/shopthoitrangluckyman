package com.DuAnTT_LuckyMan.intercepter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.DuAnTT_LuckyMan.service.CateSmallService;
import com.DuAnTT_LuckyMan.service.CategoryService;

@Component
public class Globallnterceptor implements HandlerInterceptor{
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	CateSmallService cateSmallService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", categoryService.findAll());
		request.setAttribute("catesmall", cateSmallService.findAll());
	}

}
