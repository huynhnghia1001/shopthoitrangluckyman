package com.DuAnTT_LuckyMan.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.RoleDAO;
import com.DuAnTT_LuckyMan.entity.Role;
import com.DuAnTT_LuckyMan.service.RoleService;


@Service
public class RoleServiceIml implements RoleService{

	@Autowired
	RoleDAO dao;
	
	
	public List<Role> findAll() {
		return dao.findAll();
	}
   
}
