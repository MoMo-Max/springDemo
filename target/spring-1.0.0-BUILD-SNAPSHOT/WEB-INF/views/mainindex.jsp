<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>spring</title>
</head>
<body>
<table width="100%">
<tr><td><font color="#AAA000" size="30">WELCOME TO INDEX !</font></td>
<td align="right"><font color="red" size="30">wBase</font></td></tr>
</table>
<hr size="5" align="center" noshade width="90%" color="#FFA500">

<Table border="0" width="100%">
	<tr><td>登入</td></tr>
	<tr><td><a href='userProfile.do?act=Add' >註冊</a></td></tr>
</Table>
<form action="userProfile.do?act=login" method='post'>

	<input type="text" name="account"/><br>
	<input type="password" name="passwd"/><br>
	<input type ="submit"/>
</form>

</body>
</html>