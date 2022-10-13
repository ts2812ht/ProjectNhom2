<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <jsp:include page="Header.jsp"></jsp:include>
  <form action="/action_page.php">
  <div class="container">
    <h1>Sign Up</h1>
    <hr>
    
    <label for="name"><b>Tên hiển thị(*):</b></label><br>
    <input type="text"  name="name"><br>

    <label for="username"><b>Tên đăng nhập(*):</b></label><br>
    <input type="text"  name="username"><br>

    <label for="psw"><b>Mật khẩu(*):</b></label><br>
    <input type="password"  name="psw"><br>

    <label for="psw-repeat"><b>Nhập lại mật khẩu(*):</b></label><br>
    <input type="password"  name="psw_repeat"><br>
    
    <label for="email"><b>Email:</b></label><br>
    <input type="text"  name="email"><br>
    
    <label for="phone"><b>SĐT:</b></label><br>
    <input type="text"  name="phone"><br>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Đăng ký</button>
    </div>
  </div>
</form>
  <jsp:include page="Footer.jsp"></jsp:include>