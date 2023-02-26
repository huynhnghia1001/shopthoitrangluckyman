package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DuAnTT_LuckyMan.entity.CateSmall;

public interface CateSmallDAO extends JpaRepository<CateSmall, Integer> {
	@Query("SELECT p FROM CateSmall p WHERE p.category.name=?1")
	List<CateSmall> findAllCate(String a);
	
	@Query("SELECT p FROM CateSmall p WHERE p.category.id=?1")
	List<CateSmall> findByCate(String cid);
}
