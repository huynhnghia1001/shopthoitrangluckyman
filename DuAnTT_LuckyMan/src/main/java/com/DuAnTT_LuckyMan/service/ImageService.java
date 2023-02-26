package com.DuAnTT_LuckyMan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.DuAnTT_LuckyMan.entity.Image;


public interface ImageService {

	List<Image> findByImages(Integer id);
	
	List<Image> findByProductDetail(Integer id);
	
	Image findByImagesDetail(Integer cid);
	
	List<Image> findAll();

	Image findById(Integer id);


	Image create(Image product);

	Image update(Image product);

	void delete(Integer id);

	List<Image> findId(Integer id);

}
