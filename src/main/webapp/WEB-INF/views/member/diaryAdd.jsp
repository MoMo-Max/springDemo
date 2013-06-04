<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
diaryAdd<br>
新增日記<br>

<hr size="5" align="center" noshade width="90%" color="#FFA500">
<form method ="Post" action="<%=baseUrl%>/diary.do?act=save">
	<table>
		<tr><td>標題<input name="title" type="text"/></td><tr>
		<tr><td height="200" weight="200">內容	<textarea rows="4" cols="50" name="context"></textarea></td><tr>
		<tr><td><input  type="submit"/></td></tr>
	</table>
</form>
</body>
</html>