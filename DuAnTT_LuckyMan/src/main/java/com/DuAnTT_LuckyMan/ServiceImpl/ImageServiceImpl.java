package com.DuAnTT_LuckyMan.ServiceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.ImageDAO;
import com.DuAnTT_LuckyMan.entity.Image;

import com.DuAnTT_LuckyMan.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageDAO imgdao;

	@Override
	public List<Image> findByImages(Integer id) {
		// TODO Auto-generated method stub
		return imgdao.findByImages(id);
	}

	@Override
	public List<Image> findByProductDetail(Integer id) {
		// TODO Auto-generated method stub
		return imgdao.findByProductDetail(id);
	}

	@Override
	public Image findByImagesDetail(Integer cid) {
		// TODO Auto-generated method stub
		return imgdao.findByImagesDetail(cid);
	}

	@Override
	public List<Image> findAll() {
		// TODO Auto-generated method stub
		return imgdao.findAll();
	}

	@Override
	public Image findById(Integer id) {
		// TODO Auto-generated method stub
		return imgdao.findById(id).get();
	}

	@Override
	public Image create(Image product) {
		// TODO Auto-generated method stub
		return imgdao.save(product);
	}

	@Override
	public Image update(Image product) {
		// TODO Auto-generated method stub
		return imgdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		imgdao.deleteById(id);
		
	}

	@Override
	public List<Image> findId(Integer id) {
		// TODO Auto-generated method stub
		return imgdao.findId(id);
	}


	

}
