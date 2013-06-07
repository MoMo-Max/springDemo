<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userProfileADD</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<div id="wrapper"> 
			<center>
					<div id="page" >
						<form action="userProfile.do?act=save" method="post" 
						enctype = "multipart/form-data">

帳號<input name ='account' type ='text' id="search-text"/><br>
密碼<input name ='psswd'type = 'password'id="search-text"/><br>
姓名<input name = 'name' type ='text' id="search-text"/><br>
生日<input name = 'brday' type ='text' id="search-text"/><br>
學歷<select name="edu" id="search-text">
		<option value="國中">國中 </option>
		<option value="高中">高中</option>
		<option value="大學">大學</option>
		<option value="研究所">研究所</option>
	</select><br>
檔案上傳（大頭）<input type="file" name="picture" size="30" maxlength="30"/><br>

<input type = 'submit' id="search-submit" value="送出"/>
						</form>
					</div>
			</center>
	
	</div>
<%@ include file="../include/down.jsp" %>

</body>
</html>