package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DuAnTT_LuckyMan.entity.Description;



public interface DescriptionDAO extends JpaRepository<Description, Integer>{
 
	@Query("SELECT p FROM Description p WHERE p.product.id=?1")
	List<Description> findByDescription(Integer id);

}
