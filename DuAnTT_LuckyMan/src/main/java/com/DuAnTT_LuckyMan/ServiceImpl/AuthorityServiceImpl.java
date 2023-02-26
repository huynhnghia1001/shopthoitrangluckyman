package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.AccountDAO;
import com.DuAnTT_LuckyMan.dao.AuthorityDAO;
import com.DuAnTT_LuckyMan.entity.Account;
import com.DuAnTT_LuckyMan.entity.Authority;
import com.DuAnTT_LuckyMan.service.AuthorityService;



@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	AuthorityDAO authorityDAO ;
	
	@Autowired
	AccountDAO accDao;

	@Override
	public Authority create(Authority authority) {
		return authorityDAO.save(authority);
	}
	
	public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accDao.getAdministrators();
		return authorityDAO.authoritiesOf(accounts);
	}

	
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}
	
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}

}
