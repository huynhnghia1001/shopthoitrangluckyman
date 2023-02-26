package com.DuAnTT_LuckyMan.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.CategoryDAO;
import com.DuAnTT_LuckyMan.entity.Category;
import com.DuAnTT_LuckyMan.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

}
