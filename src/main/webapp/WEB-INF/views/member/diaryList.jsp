<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oo.spring.model.diary" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Timestamp" %>
<%@ include file = "../top.jsp" %>
<% List diList = (List)request.getAttribute("diary"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日誌</title>
</head>
<body>
<ul>
	<li>每日日誌</li>
	<li><a href="<%=baseUrl %>/member.do?act=add">新增</a></li>
</ul>
<br>
<table> 
<%

	for(int i = 0 ;i < diList.size();i++){
	 
			//diary diar = new diary();
			
			Integer id 	= ((diary)diList.get(i)).getId();
			String title= ((diary)diList.get(i)).getTitle();
			String content = ((diary)diList.get(i)).getContext();
			Timestamp  time=((diary)diList.get(i)).getCreateDate();
			
		/*
		
		for(Map userMap : diList){

            Integer id = new Integer(userMap.get("id").toString());
            String title = userMap.get("title").toString();
            String context =  userMap.get("content").toString();
           
            
     */
		

%>
<tr><td><%= id %></td> <td><%= title %></td><td><%=content %></td></tr>
<%} %>
</table>
</body>
</html>