package com.DuAnTT_LuckyMan.Rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DuAnTT_LuckyMan.entity.CateSmall;
import com.DuAnTT_LuckyMan.service.CateSmallService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/catesmall")
public class CateSmallRestController {
    @Autowired
    CateSmallService catesmalService;
    
	@GetMapping()
	public List<CateSmall> getAll() {
		return catesmalService.findAll();
	}
}
