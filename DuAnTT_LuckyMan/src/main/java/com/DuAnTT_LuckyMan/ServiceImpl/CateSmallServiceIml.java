package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.CateSmallDAO;
import com.DuAnTT_LuckyMan.entity.CateSmall;
import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.service.CateSmallService;

@Service
public class CateSmallServiceIml implements CateSmallService{

	@Autowired
	CateSmallDAO smdao;
	
	@Override
	public List<CateSmall> findAll() {
		
		return smdao.findAll();
	}
       
	@Override
	public List<CateSmall> findByCateSmall(String cid) {
		// TODO Auto-generated method stub
		return smdao.findByCate(cid);
	}
}
