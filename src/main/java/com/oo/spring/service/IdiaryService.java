package com.oo.spring.service;

import java.util.List;

import com.oo.spring.model.diary;



public interface IdiaryService {
	
	public void save(diary diaryer);
	
	public diary find(Integer id);
	 
	public List list();

}
