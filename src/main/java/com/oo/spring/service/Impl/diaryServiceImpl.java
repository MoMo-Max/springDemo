package com.oo.spring.service.Impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.oo.spring.model.diary;
import com.oo.spring.service.IdiaryService;

public class diaryServiceImpl implements IdiaryService{
	
	 private NamedParameterJdbcTemplate jdbcTemplate;
	    
	    public void setDataSource(DataSource dataSource) {
	        jdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
	    }
	   /*  
	    private DataSource dataSource;
	    
	    public void setDataSource(DataSource dataSource) {
	        this.dataSource = dataSource;
	    }
*/

	public void save(diary diaryer) {
		// TODO Auto-generated method stub
		
		
		String sql = "INSERT INTO diary (title,content,createDate) " +
				"VALUES(:title, :context, :createDate)";
	       SqlParameterSource namedParameters = 
	           new BeanPropertySqlParameterSource(diaryer);
	       
	       jdbcTemplate.update(sql, namedParameters);
		
		
	       
	}
	
	    /*
	    public void save(diary diar){
	    	
	    	Connection conn = null;
		    PreparedStatement pst = null;
			String sql="";
			Date date = new Date();
		    try {
		    	
		    	sql="Insert into diary(title,content,CreateDate) values(?,?,?)";
		    	
	            conn = dataSource.getConnection();
	            pst = conn.prepareStatement(sql);
	            
	            System.out.println("DAO = : title="+diar.getTitle());
	            pst.setString(1, diar.getTitle());
	            pst.setString(2, diar.getContext());
	            pst.setTimestamp(3, diar.getCreateDate());
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
	    	
	    }
	    */
	   public diary find(Integer id) {
	        String sql = "SELECT * FROM diary WHERE id=:userId";
	        SqlParameterSource namedParameters = new MapSqlParameterSource("userId", id);
	        List rows = jdbcTemplate.queryForList(sql, namedParameters);
	        
	        Iterator it = rows.iterator();
	        if(it.hasNext()) {
	            Map userMap = (Map) it.next();

	            Integer i = new Integer(userMap.get("id").toString());
	            String title = userMap.get("title").toString();
	            String context =  userMap.get("content").toString();

	            diary diar = new diary();
	            diar.setId(i);
	            diar.setTitle(title);
	            diar.setContext(context);
	            
	            return diar;
	        }

	        return null;
	    }
/*   舊有的  可以list 一筆 */
	@Override
	public List list() {
			
			List listadd = new ArrayList();
		  	String sql = "SELECT * FROM diary ";
	        SqlParameterSource paramMap = null;
			List rows = jdbcTemplate.queryForList(sql, paramMap);
	        
	        Iterator it = rows.iterator();
	        
	       while(it.hasNext()){
	    	   
	            Map userMap = (Map)it.next();

	            Integer id = new Integer(userMap.get("id").toString());
	            String title = userMap.get("title").toString();
	            String context =  userMap.get("content").toString();

	            diary diar = new diary();
	            diar.setId(id);
	            diar.setTitle(title);
	            diar.setContext(context);
	            listadd.add(diar);       
	            
	        }
	        System.out.println("test?");
			return listadd;
		
	}

}
