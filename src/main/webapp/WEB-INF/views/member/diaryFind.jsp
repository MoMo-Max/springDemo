<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oo.spring.model.diary" %>
<%@ include file ="../top.jsp" %>
<%	diary di = (diary)request.getAttribute("diaryfind"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form method="POST" action="<%=baseUrl %>/diary.do?act=updateDiary">
	
		<input name ="id" type ="hidden" value="<%=di.getId() %>"/>
 		<input  name ="title" type="text" value="<%=di.getTitle() %>" /><br>
		<textarea name="content" row="4"><%=di.getContent() %></textarea><br>
		<input type="submit" />	

	</form>

</body>
</html>