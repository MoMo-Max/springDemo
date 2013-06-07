package com.oo.spring.model;

import java.sql.Timestamp;
import java.util.Date;

public class userProfile {
	
	private Integer id;
	private String account;  //帳號

	private String psswd;   //密碼
	private String name;   //姓名
	
	private String edu;
	private Timestamp dateTime;
	//private Date brday;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getAccount() {
		return account;
	}
	public String getEdu() {
		return edu;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
		
	
	
}
