package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.DuAnTT_LuckyMan.entity.Image;


public interface ImageDAO extends JpaRepository<Image, Integer> {
  
	@Query("SELECT p FROM Image p WHERE p.product.id=?1")
	List<Image> findByImages(Integer id);
	
	@Query("SELECT p FROM Image p WHERE p.productdetail.id=?1")
	List<Image> findByProductDetail(Integer id);
	
	@Query("SELECT p FROM Image p WHERE p.productdetail.id=?1")
	Image findByImagesDetail(Integer cid);
	
	@Query("SELECT p FROM Image p WHERE p.product.id=?1")
	List<Image> findId(Integer id);
}
