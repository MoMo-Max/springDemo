package com.oo.spring.service;

import java.sql.ResultSet;
import java.util.List;

import com.oo.spring.model.userProfile;

public interface userProfileService {
	
	public void save(userProfile user);
	
	
	public boolean checkLogin(String account,String password);
	
	public ResultSet list();
	
}
