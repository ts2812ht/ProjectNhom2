<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <jsp:include page="Header.jsp"></jsp:include>
 <form action="NewPost_servlet" method="post">

    <label for="name"><b>Tên hiển thị(*):</b></label><br>
    <input type="text"  name="name"><br>

    <label for="username"><b>Tên đăng nhập(*):</b></label><br>
    <input type="text"  name="username"><br>

    <label for="psw"><b>Mật khẩu(*):</b></label><br>
    <input type="password"  name="pass"><br>

    <label for="psw-repeat"><b>Nhập lại mật khẩu(*):</b></label><br>
    <input type="password"  name="repass"><br>
    
    <label for="email"><b>Email:</b></label><br>
    <input type="text"  name="email"><br>
    
    <label for="phone"><b>SĐT:</b></label><br>
    <input type="text"  name="phone"><br>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Đăng ký</button>
    </div>
</form>
  <jsp:include page="Footer.jsp"></jsp:include>