package com.DuAnTT_LuckyMan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.DuAnTT_LuckyMan.entity.CateSmall;


public interface CateSmallService {
	List<CateSmall> findAll();
	

	List<CateSmall> findByCateSmall(String cid);
}
