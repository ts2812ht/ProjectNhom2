<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Dto.UserDTO"%>
<!DOCTYPE html>
<html>
<body>
<div>
	<h1>Logo</h1><br>
	<a href="Post_servlet">Trang chủ</a>
	<p>Tài khoản của ${sessionScope.user.name}</p>
	<div>
		<h3>Avatar:</h3>
		<img src="${sessionScope.user.avatar}" width="50" height="50" alt="image 1"/>
	</div>
	<br><br><br><br>
</body>
</html>