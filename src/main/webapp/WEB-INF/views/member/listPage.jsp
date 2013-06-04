<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession getSession = request.getSession();
	String account=(String)getSession.getAttribute("account");
	String baseUrl=request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+request.getContextPath();
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員中心</title>
</head>
<body>
<h1>會員中心  <%=account %></h1>
<%=baseUrl %><br>
<br><a href="<%=baseUrl %>/member.do?act=list" >會員資料</a>
<br><a href="<%=baseUrl %>/diary.do?act=diaryList" >每日工作日記</a>
<br><a href="123" >123</a>

</body>
</html>