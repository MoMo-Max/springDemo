package com.oo.spring.controller.front;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.
                  multiaction.MultiActionController;
import org.springframework.web.servlet.view.RedirectView;

import com.oo.spring.model.diary;
import com.oo.spring.service.userProfileService;
import com.oo.spring.service.IdiaryService;

public class memberController extends MultiActionController {
   
   
    private String listPage;
    private String listShow;
    private String diaryListPage;
    
    private String diaryAdd;
    
    private userProfileService userProfileService;
    private IdiaryService IdiaryService;
    private String saveSuccessView; 
    

	//MAX list member 
    
    public ModelAndView list(HttpServletRequest request,
    							HttpServletResponse response){
		
    	String str="HELLO MVC list" ;
    	
    	//TODO
    	ResultSet list= userProfileService.list();
    	
    	
    	return new ModelAndView(listShow,"list",list);
    }
    
    /**
     * 
     * author MAX
     * 日記處理
     * 
     * */
    public ModelAndView diaryList(HttpServletRequest request,
    							HttpServletResponse response){
    	
    	
    	List di=IdiaryService.list();

    	
    	return new ModelAndView(diaryListPage,"diary",di);
    }
    /**
     * 
     * author Max
     * Insert
     * 
     * */
    public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response){
    	
    	return new ModelAndView(diaryAdd);
    }
    /**
     * 
     * author Max
     * SAVE
     * 
     * */
    public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response){
    	
    	diary diar = new diary();
    	
    	String title = request.getParameter("title");
    	String context = request.getParameter("context");
    	
    	Timestamp now = new Timestamp(System.currentTimeMillis());

    	diar.setTitle(title);
    	diar.setContext(context);
    	diar.setCreateDate(now);
    	
    	IdiaryService.save(diar);
    	
    	
    	//return new ModelAndView(new RedirectView("http://localhost:8080/spring/member.do?act=diaryList"));
    	return new ModelAndView(new RedirectView(saveSuccessView));
    	  
    }



	public String getListPage() {
		return listPage;
	}


	public void setListPage(String listPage) {
		this.listPage = listPage;
	}

	public String getListShow() {
		return listShow;
	}


	public void setListShow(String listShow) {
		this.listShow = listShow;
	}


	public userProfileService getUserProfileService() {
		return userProfileService;
	}


	public void setUserProfileService(userProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	public String getDiaryListPage() {
		return diaryListPage;
	}

	public void setDiaryListPage(String diaryListPage) {
		this.diaryListPage = diaryListPage;
	}

	public String getDiaryAdd() {
		return diaryAdd;
	}

	public void setDiaryAdd(String diaryAdd) {
		this.diaryAdd = diaryAdd;
	}

	public IdiaryService getIdiaryService() {
		return IdiaryService;
	}

	public void setIdiaryService(IdiaryService idiaryService) {
		IdiaryService = idiaryService;
	}

	public String getSaveSuccessView() {
		return saveSuccessView;
	}

	public void setSaveSuccessView(String saveSuccessView) {
		this.saveSuccessView = saveSuccessView;
	}
	


}
