package com.DuAnTT_LuckyMan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DuAnTT_LuckyMan.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('ADMIN','STAFF')")
    List<Account> getAdministrators();
    
    @Query("SELECT p FROM Account p WHERE p.fullname LIKE ?1 ")
    List<Account> findByName(String fullname);
}
