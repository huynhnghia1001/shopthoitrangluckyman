package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DuAnTT_LuckyMan.entity.ProductDetail;

public interface ProductDetailDAO extends JpaRepository<ProductDetail, Integer> {
     
	@Query("SELECT p FROM ProductDetail p WHERE p.product.id=?1")
	List<ProductDetail> findByProductDetail(Integer id);
	
	@Query("SELECT p FROM ProductDetail p WHERE p.product.id LIKE ?1 ")
	List<ProductDetail> findid(Integer id);

	@Query("SELECT p FROM ProductDetail p WHERE p.size LIKE ?1 ")
	List<ProductDetail> findsize(String size);
} 
