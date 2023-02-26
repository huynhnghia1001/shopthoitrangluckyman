package com.DuAnTT_LuckyMan.service;

import java.util.List;

import com.DuAnTT_LuckyMan.entity.Description;


public interface DescriptionService {
	List<Description>findByDescription(Integer id);
}
