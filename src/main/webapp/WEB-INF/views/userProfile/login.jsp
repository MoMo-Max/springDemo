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
		
			<center>
					<div id="search" >
						<form method="POST" action="<%=baseUrl %>/userProfile.do?act=login">
							<div>
								<input type="text" name="account" id="search-text" value="" /><br>
								<input type="password" name="passwd" id="search-text" value="" /><br>
								<input type="submit" id="search-submit" value="登入" />
							</div>				
						</form>
					</div>
			</center>
	
	</div>
<%@ include file="../include/down.jsp" %>

</body>
</html>