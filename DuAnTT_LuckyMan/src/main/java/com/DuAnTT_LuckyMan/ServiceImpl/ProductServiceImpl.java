package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.ImageDAO;
import com.DuAnTT_LuckyMan.dao.ProductDAO;
import com.DuAnTT_LuckyMan.entity.Image;
import com.DuAnTT_LuckyMan.entity.Product;
import com.DuAnTT_LuckyMan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	ImageDAO idao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return pdao.findById(id).get();
	}

	@Override
	public Page<Product> findByCategoryId(String cid,Pageable pa) {
		// TODO Auto-generated method stub
		return pdao.findByCategoryId(cid,pa);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 pdao.deleteById(id);
	}

	@Override
	public Page<Product> findAvail(Pageable pa) {
		return pdao.findAvailable(pa);
	}

	
	public List<Product> findByName(String name) {
		return pdao.findByName(name);
	}

	public List<Product> findByPrice(Double price) {
		 return pdao.findByPrice(price);
	}

	@Override
	public List<Product> findByNameCate(String name, String cateid) {
		
		return pdao.findByNameCate(name,cateid);
	}

	@Override
	public List<Product> timTheoTen(String fullname) {
		return pdao.timTheoTen(fullname);
	}

//	@Override
//	public Page<Product> findStatus(Pageable pa) {
//		return pdao.findStatus(pa);
//	}
	
	@Override
	public Page<Product> findAllByName(String name,Pageable pa) {
		return pdao.findAllByName(name,pa);
	}
	

}
