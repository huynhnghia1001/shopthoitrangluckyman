package com.DuAnTT_LuckyMan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.DuAnTT_LuckyMan.entity.Product;

public interface ProductService {
	
	List<Product> findAll();

	Product findById(Integer id);

	Page<Product> findByCategoryId(String cid,Pageable pa);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

	Page<Product> findAvail(Pageable pa);

	List<Product> findByName(String name);

	List<Product> findByPrice(Double price);

    List<Product> findByNameCate(String name,String cateid);

	List<Product> timTheoTen(String fullname);
    
//    Page<Product> findStatus(Pageable pa);
	
	Page<Product> findAllByName(String name,Pageable pa);


}
