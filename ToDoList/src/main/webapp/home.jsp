<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%User user = (User)session.getAttribute("user");
	String name = user.getUsername();
	String email = user.getUseremail();
	String image = new String(Base64.getEncoder().encode(user.getUserimage()));
	%>
	
	<h2>WELCOME <%=name %></h2>
	<h4><%=email %></h4>
	<img alt="" src="data:image/jpeg:base64, <%=image %>" width="100" height="100">
</body>
</html>