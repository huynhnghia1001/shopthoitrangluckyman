package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.ProductDetailDAO;
import com.DuAnTT_LuckyMan.entity.ProductDetail;
import com.DuAnTT_LuckyMan.service.ProductDetailService;

@Service
public class ProductDetailServiceImpl implements ProductDetailService{

	@Autowired
	ProductDetailDAO detailDao;
	
	@Override
	public List<ProductDetail> findByProductDetail(Integer id) {
		// TODO Auto-generated method stub
		return detailDao.findByProductDetail(id);
	}

	@Override
	public ProductDetail findById(Integer id) {
		return detailDao.findById(id).get();
	}
	
	@Override
	public ProductDetail create(ProductDetail product) {
		return detailDao.save(product);
	}

	@Override
	public ProductDetail update(ProductDetail product) {
		return detailDao.save(product);
	}

	@Override
	public void delete(Integer id) {
		detailDao.deleteById(id);
	}

	@Override
	public List<ProductDetail> findAll() {
		return detailDao.findAll();
	}
	
	@Override
	public List<ProductDetail> findid(Integer id) {
		return detailDao.findid(id);
	}

	@Override
	public List<ProductDetail> findsize(String size) {
		return detailDao.findsize(size);
	}


}
