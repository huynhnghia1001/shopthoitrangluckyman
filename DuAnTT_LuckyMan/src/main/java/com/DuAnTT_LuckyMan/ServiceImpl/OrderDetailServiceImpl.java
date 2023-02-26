package com.DuAnTT_LuckyMan.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.OrderDetailDAO;
import com.DuAnTT_LuckyMan.entity.OrderDetail;
import com.DuAnTT_LuckyMan.service.OrderDetailService;



@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	    @Autowired
	    OrderDetailDAO detailDao;

		@Override
		public List<OrderDetail> findAll() {
			return detailDao.findAll();
		}

		@Override
		public OrderDetail create(OrderDetail orderDetail) {
			return detailDao.save(orderDetail);
		}

		@Override
		public OrderDetail update(OrderDetail orderDetail) {
			return detailDao.save(orderDetail);		}

		@Override
		public void delete(Integer id) {
			detailDao.deleteById(id);
			
		}
}
