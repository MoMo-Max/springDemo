package com.oo.spring.controller.front;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.
                  multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import com.oo.spring.WS.IHello;
import com.oo.spring.model.userProfile;
import com.oo.spring.service.userProfileService;





public class userProfileFrontController extends MultiActionController{
	
	private String successAdd;
	private String SaveOK;
	private String loginOK;
	private IHello greetWebService;   // WebService 測試
	
	private userProfileService userProfileService;
	
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response){
		
		String username=request.getParameter("user");
		String password=request.getParameter("passwd");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println("This is List!!");
		
		return new ModelAndView(successAdd);
	}
	public ModelAndView Add(HttpServletRequest request,
			HttpServletResponse response){
		
		/*String username=request.getParameter("user");
		String password=request.getParameter("passwd");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println("This is ADD!!");*/
		
		
		return new ModelAndView(successAdd);
	}
	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response){
		//TODO
		Timestamp now = new Timestamp(System.currentTimeMillis());
		
		String name=request.getParameter("user");
		String psswd=request.getParameter("psswd");
		
		userProfile user = new userProfile();
		//user.setId(id);
		user.setName(name);
		user.setPsswd(psswd);
		user.setDateTime(now);
		
		System.out.println(user.getName());
	
		userProfileService.save(user);
		
		
		return new ModelAndView(SaveOK);
	}
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response){
		
		String account = request.getParameter("account");
		String passwd  = request.getParameter("passwd");
		
		boolean check =userProfileService.checkLogin(account, passwd);
		//This WebService Start call 
		
		List list = new ArrayList();
		
		list.add("Max");
		list.add("Jimmy");
		list.add("bill");
		list.add("Kevin");
		
		// WebService  測試
		String client = greetWebService.geetHell("Max");
		String client2 = greetWebService.geetList(list);
		
		
		System.out.println(client);
		System.out.println(client2);
		if(check){
			request.getSession().setAttribute("account", account);
			System.out.println("OKLogin");
			return new ModelAndView(loginOK);
		}else{
			System.out.println("NOKLogin");
			return new ModelAndView(SaveOK);
		}
	}
	public ModelAndView loginOut(HttpServletRequest request,
			HttpServletResponse response){
	
			request.getSession().invalidate();
		
				return new ModelAndView();
	}
	
	public String getSuccessAdd() {
		return successAdd;
	}

	public void setSuccessAdd(String successAdd) {
		this.successAdd = successAdd;
	}
	public String getSaveOK() {
		return SaveOK;
	}
	public void setSaveOK(String saveOK) {
		SaveOK = saveOK;
	}
	public userProfileService getUserProfileService() {
		return userProfileService;
	}
	public void setUserProfileService(userProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}
	public String getLoginOK() {
		return loginOK;
	}
	public void setLoginOK(String loginOK) {
		this.loginOK = loginOK;
	}
	public IHello getGreetWebService() {
		return greetWebService;
	}
	public void setGreetWebService(IHello greetWebService) {
		this.greetWebService = greetWebService;
	}
	
	

}
