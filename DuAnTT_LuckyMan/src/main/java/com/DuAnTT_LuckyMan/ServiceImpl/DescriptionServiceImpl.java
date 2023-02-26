package com.DuAnTT_LuckyMan.ServiceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.DescriptionDAO;
import com.DuAnTT_LuckyMan.entity.Description;

import com.DuAnTT_LuckyMan.service.DescriptionService;

@Service
public class DescriptionServiceImpl implements DescriptionService{

	@Autowired
	DescriptionDAO dedao;

	@Override
	public List<Description> findByDescription(Integer id) {
		
		return dedao.findByDescription(id);
	}
	
    
    
}


