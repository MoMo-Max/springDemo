package com.oo.spring.controller.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.oo.spring.service.IdiaryService;

public class indexController extends MultiActionController{
	
	private String findSuccessView;
    private IdiaryService IdiaryService;
	
	public ModelAndView list (HttpServletRequest request,
			HttpServletResponse response){
		
		//TODO something
		List di=IdiaryService.list();
		
		request.setAttribute("Idiary", di);		
		
		return new ModelAndView(findSuccessView);
	}

	public String getFindSuccessView() {
		return findSuccessView;
	}

	public void setFindSuccessView(String findSuccessView) {
		this.findSuccessView = findSuccessView;
	}

	public IdiaryService getIdiaryService() {
		return IdiaryService;
	}

	public void setIdiaryService(IdiaryService idiaryService) {
		IdiaryService = idiaryService;
	}

	
	

}
