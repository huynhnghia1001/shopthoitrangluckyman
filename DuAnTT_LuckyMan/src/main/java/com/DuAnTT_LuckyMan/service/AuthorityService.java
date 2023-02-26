package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.Authority;

public interface AuthorityService {

	Authority create(Authority authority);
	
	public void delete(Integer id);
	
	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();
}
