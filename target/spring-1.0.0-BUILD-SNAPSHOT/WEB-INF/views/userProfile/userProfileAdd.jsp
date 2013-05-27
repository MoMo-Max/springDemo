<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>註冊會員</title>
</head>
<body>
註冊會員<br>
<form action="userProfile.do?act=save" method="post">

帳號<input name ='user' type ='text' /><br>
密碼<input name ='psswd'type = 'password'/><br>
姓名<input name = 'name' type ='text' /><br>
生日<input name = 'brday' type ='text' /><br>
學歷<select name="edu">
		<option value="1">國中 </option>
		<option value="2">高中</option>
		<option value="3">大學</option>
		<option value="4">研究所</option>
	</select>

<input type = 'submit' />
</form>
 
</body>
</html>