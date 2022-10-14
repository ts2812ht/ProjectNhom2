<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="Dto.UserDTO"%>
<!DOCTYPE html>
<html>
<body>
<div>
	<h1>Logo</h1><br>
	<%
		UserDTO user = null;
		String isLoginUrl = "LoginForm.jsp";
		if (session.getAttribute("user") != null) {
        	user = (UserDTO) session.getAttribute("user");
        	isLoginUrl = "NewPost.jsp";
    	}%>
	<% if (user != null) {%>
   	<p>Xin chào </p>
   	<p style="color:red;"><span style=""><%out.print(user.getName()); %></span></p><br>
   	<a href="AccountDetail.jsp">Chỉnh sửa thông tin tài khoản</a><br>
   	<a href="MyPost_servlet">Bài đăng của tôi</a><br>
	<a href="Logout">Logout</a><%}%>
   	<% if (user == null) {%>
   		<a href="LoginForm.jsp">Đăng nhập</a>
		<a href="RegisterForm.jsp">Đăng kí</a><%}%>
</div>
<br>
<a href="<%out.print(isLoginUrl);%>">Đăng tin mới</a><br>
<br>
<div>
	<a href="Post_servlet">Trang chủ</a>
	<a href="Post_servlet?Cid=1">Cho thuê</a>
	<a href="Post_servlet?Cid=2">Ở ghép</a>
	<a href="Post_servlet?Cid=3">Nguyên căn</a>
	<a href="Post_servlet?Cid=4">Chung cư</a>
</div>

</body>
</html>