package com.DuAnTT_LuckyMan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DuAnTT_LuckyMan.entity.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Integer> {

}
