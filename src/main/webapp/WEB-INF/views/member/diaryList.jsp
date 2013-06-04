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
<script type="text/javascript">
	
	function find(id){
		var frm = document.forms["find2"];	
		
		frm.id.value=id;
		frm.submit();
		
	}
	function del(id){
		var frm = document.forms["find2"];	
		alert("test"+id);
		frm.id.value=id;
		frm.act.value="DelDiary";
		frm.submit();
		
	}
	

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日誌</title>
</head>
<body>
<ul>
	<li>每日日誌</li>
	<li><a href="<%=baseUrl %>/diary.do?act=add">新增</a></li>
</ul>
<br>
	<form name ="find2" method="POST" action="<%= baseUrl %>/diary.do" >
		<input type="hidden" name = "id" />
		<input type="hidden" name = "act"  value="findDiary"/>
	</form>
<table border="1"> 
<%

	for(int i = 0 ;i < diList.size();i++){
	 
			//diary diar = new diary();
			
			Integer id 	= ((diary)diList.get(i)).getId();
			String title= ((diary)diList.get(i)).getTitle();
			String content = ((diary)diList.get(i)).getContent();
			Timestamp  time=((diary)diList.get(i)).getCreateDate();	
		/*
		
		for(Map userMap : diList){

            Integer id = new Integer(userMap.get("id").toString());
            String title = userMap.get("title").toString();
            String context =  userMap.get("content").toString();                    
     */

%>
<tr>
	<td><%= id %></td> 
	<td><%= title %></td>
	<td><%=content %></td>
	<td><a href="javascript:onclick:find(<%= id%>)">修改</a></td>
	<td><a href="javascript:onclick:del(<%=id%>)">刪除</a></td></tr>
<%} %>
</table>
</body>
</html>