package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DuAnTT_LuckyMan.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	

	   @Query("SELECT p FROM Product p WHERE p.Catesmall.category.id=?1")
	   Page<Product> findByCategoryId(String cid,Pageable pa);
	   
	   @Query("SELECT p FROM Product p WHERE p.available=true")
	   Page<Product> findAvailable(Pageable pa);
	   
	   @Query("SELECT p FROM Product p WHERE p.name LIKE ?1 ")
	   List<Product> findByName(String name);
	   
	   @Query("SELECT p FROM Product p WHERE p.price=?1")
	   List<Product> findByPrice(Double price);

//	   @Query("SELECT p FROM Product p WHERE p.categoryId=?1")
//	   Page<Product> findByCategoryId(String cid);
	   
	   @Query("SELECT p FROM Product p WHERE p.Catesmall.name=?1 and p.Catesmall.category.id=?2")
	   List<Product> findByNameCate(String name,String cateid);

	   @Query("SELECT p FROM Product p WHERE p.name LIKE ?1")
	   List<Product> timTheoTen(String fullname);
	   
	   @Query("SELECT p FROM Product p WHERE p.name LIKE ?1 ")
	   Page<Product> findAllByName(String name, Pageable pa);
}
