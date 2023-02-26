package com.DuAnTT_LuckyMan.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DuAnTT_LuckyMan.dao.AccountDAO;
import com.DuAnTT_LuckyMan.entity.Account;
import com.DuAnTT_LuckyMan.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO ;
	
	@Override
	public Account findById(String id) {
		return accountDAO.findById(id).get();
	}
	
	public List<Account> getAdministrators() {
		return accountDAO.getAdministrators();
	}

	@Override
	public Account create(Account account) {
		return accountDAO.save(account);
	}

	@Override
	public List<Account> findAll() {
		return accountDAO.findAll();
	}

	@Override
	public Account update(Account account) {
		return accountDAO.save(account);
	}
	
	public void delete(String username) {
		// TODO Auto-generated method stub
		accountDAO.deleteById(username);
	}


	@Override
	public List<Account> findByName(String fullname) {
		return accountDAO.findByName(fullname);
	}
	
	@Override
	public void save(Account user) {
		accountDAO.save(user);
	}
	

}
