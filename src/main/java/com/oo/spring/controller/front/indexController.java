package com.oo.spring.controller.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class indexController extends MultiActionController{
	
	private String findSuccessView;
	
	public ModelAndView list (HttpServletRequest request,
			HttpServletResponse response){
		
		//TODO something
		
		return new ModelAndView(findSuccessView);
	}

	public String getFindSuccessView() {
		return findSuccessView;
	}

	public void setFindSuccessView(String findSuccessView) {
		this.findSuccessView = findSuccessView;
	}

}
