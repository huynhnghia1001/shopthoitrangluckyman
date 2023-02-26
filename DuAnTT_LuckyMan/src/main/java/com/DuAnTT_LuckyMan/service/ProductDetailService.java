package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.ProductDetail;



public interface ProductDetailService {
	List<ProductDetail> findByProductDetail(Integer id);

	ProductDetail findById(Integer id);
	
	ProductDetail create(ProductDetail product);

	ProductDetail update(ProductDetail product);
	
	void delete(Integer id);

	List<ProductDetail> findAll();




	List<ProductDetail> findid(Integer id);

	List<ProductDetail> findsize(String size);

}
