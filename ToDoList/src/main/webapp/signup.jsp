<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	<form action="saveuser" method="post" enctype="multipart/form-data">

	id:<input type="text" name="id"><br>
	name:<input type="text" name="name"><br>
	email:<input type="email" name="email"><br>
	contact:<input type="text" name="contact"><br>
	password:<input type="text" name="password"><br>
	image:<input type="file" name="image"><br>
	<input type="submit">
 </form>
</body>
</html>