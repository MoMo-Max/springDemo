<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.oo.spring.model.diary" %>
<%
	List diary = (List)request.getAttribute("Idiary");
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Heavenly Bliss by FCT</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div id="wrapper"> 
	<!-- end #header -->
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				
				<!-- end #sidebar -->
				<div id="content">
				<%
				for(int i = 0; i< diary.size();i++){
					diary di = (diary)(diary.get(i));
				%>
				
					<div class="post">
						<h2 class="title"><a href="#"><%=di.getTitle()%></a></h2>
						<p class="meta"><span class="date"><%=di.getCreateDate() %></span><span class="posted">Posted by <a href="#">Someone</a></span></p>
						<div style="clear: both;">&nbsp;</div>
						<div class="entry">
							<P><%=di.getContent() %></p>
						</div>
					</div>
					<%} %>
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				
				<div id="sidebar2">
					<ul>
						<li>
							<h2>日曆</h2>
							<p>日曆區 http://www.dynarch.com/jscal/#sec5</p>
						</li>
						<li>
							<h2>Suspendisse libero</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
						<li>
							<h2>文章排列搜尋</h2>
							<ul>
								<li><a href="#">一月</a></li>
								<li><a href="#">二月</a></li>
								<li><a href="#">三月</a></li>
								<li><a href="#">四月幾個章</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
						<li>
							<h2>Lorem Ipsum</h2>
							<ul>
								<li><a href="#">Aliquam libero</a></li>
								<li><a href="#">Consectetuer adipiscing elit</a></li>
								<li><a href="#">Metus aliquam pellentesque</a></li>
								<li><a href="#">Suspendisse iaculis mauris</a></li>
								<li><a href="#">Urnanet non molestie semper</a></li>
								<li><a href="#">Proin gravida orci porttitor</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div style="clear: both;">&nbsp;</div>
			</div>
		</div>
	</div>
	<!-- end #page --> 
</div>

	<jsp:include page ="include/down.jsp"/>
<!-- end #footer -->
</body>
</html>
