<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String baseUrl =request.getScheme()+"://"+request.getServerName()+":"+
		request.getServerPort()+request.getContextPath(); 
		
	String loginName = (String)request.getSession().getAttribute("account");

%> 
   
<head>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="http://localhost:8080/spring/style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<div id="menu-wrapper">
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="<%=baseUrl%>/index.do">Homepage</a></li>
			<li><a href="#">Blog</a></li>
			<li><a href="#">Photos</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Links</a></li>
			<li><a href="#">Contact</a></li>
			<%if(loginName ==null) {%>
			<li><a href="<%=baseUrl%>/userProfile.do?act=list">Login</a></li>
			<%}else{ %>
			<li><a href="">您好！<%=loginName %></a></li>
			<li><a href="<%=baseUrl%>/userProfile.do?act=loginOut">LoginOut</a>
			<%} %>
		</ul>
	</div>
	<!-- end #menu --> 
</div>
<div id="banner-wrapper">
	<div id="banner"><a href="#"><img src="http://localhost:8080/spring/images/img01.jpg" width="1200" height="300" alt="" /></a></div>
</div>
<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">Heavenly <span>Bliss</span></a></h1>
			<p>Template design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a></p>
		</div>
	</div>
</div>