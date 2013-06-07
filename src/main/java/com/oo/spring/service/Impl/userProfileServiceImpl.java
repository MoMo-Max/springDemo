package com.oo.spring.service.Impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.oo.spring.model.userProfile;
import com.oo.spring.service.userProfileService;

public class userProfileServiceImpl implements userProfileService{

	 private DataSource dataSource;
	    
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }

	@Override
	public void save(userProfile user) {
		// TODO Auto-generated method stub
		Connection conn = null;
	    PreparedStatement pst = null;
		String sql="";
		Date date = new Date();
	    try {
	    	
	    	sql="Insert into user(account,password,CreateDate,name,edu) values(?, ?, ?, ?, ?)";
	    	int i = 0;
            conn = dataSource.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(++i, user.getAccount());
            pst.setString(++i, user.getPsswd());
            pst.setTimestamp(++i, user.getDateTime());
            
            pst.setString(++i, user.getName());
            pst.setString(++i, user.getEdu());
            //Timestamp createDateTime; //建檔日期
            pst.executeUpdate();
            
            
           
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	    
	    
		System.out.println("this save");
		System.out.println(user.getName());
		System.out.println(user.getPsswd());
		
		
	}

	@Override
	public boolean checkLogin(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
	    PreparedStatement pst = null;
		String sql="select * from user where account= ? and password =?";
		
		
		
		try {

			 conn = dataSource.getConnection();
	         pst = conn.prepareStatement(sql);
	         pst.setString(1, account);
	         pst.setString(2, password);
	         
	         ResultSet rs =pst.executeQuery();
	         
	         if(rs.next()){
	        	 return true;
	         }else{
	        	 return false;
	         }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
        	if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		return true;
	}
	public ResultSet list(){
		Connection conn = null;
	    PreparedStatement pst = null;
		String sql="select * from diary ";
		ResultSet rs = null;
		
		try {

			 conn = dataSource.getConnection();
	         pst = conn.prepareStatement(sql);
	          rs =pst.executeQuery();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  rs;
	}

	

}
