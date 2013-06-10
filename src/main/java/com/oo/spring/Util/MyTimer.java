package com.oo.spring.Util;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyTimer
 */
public class MyTimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 Timer timer;
	 int i=0;        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTimer() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
        TimerTask task = new TimerTask(){ 
  	        public void run() {
              System.out.println(new Date());
              i++;	      
  	        } 
        };
        timer = new Timer();  
        timer.schedule(task, 3000,3000);
       
      }
      
	

}
