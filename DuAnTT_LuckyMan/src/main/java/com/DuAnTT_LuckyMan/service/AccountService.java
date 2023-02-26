package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.Account;

public interface AccountService {

	Account findById(String id);

	Account create(Account account);

	List<Account> findAll();

	Account update(Account account);
	
	void delete(String username);

	public List<Account> findByName(String fullname);
	
	public List<Account> getAdministrators();

	void save(Account user);

}
