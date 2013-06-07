<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>

	<div id="wrapper"> 
				
					<div id="page">
						<div>
						<form method="POST" action="<%=baseUrl %>/userProfile.do?act=login">
						
								帳號<input type="text" name="account" id="search-text" value="" /><br>
								密碼<input type="password" name="passwd" id="search-text" value="" /><br>
								<a href = "<%=baseUrl %>/userProfile.do?act=Add">註冊</a>
								<input type="submit" id="search-submit" value="登入" />
						</form>	
						</div>
					</div>
			
	
	</div>
<%@ include file="../include/down.jsp" %>

</body>
</html>