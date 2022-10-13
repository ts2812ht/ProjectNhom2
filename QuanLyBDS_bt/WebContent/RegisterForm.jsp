<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <jsp:include page="Header.jsp"></jsp:include>
 <form action="Register_servlet" method="post">
    <h1>Sign Up</h1>
    <hr>
    <%
	    String err = (String) request.getAttribute("error");
	    if (err != null) {
	%><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err); %></span></p><%}%>
	    <%
	        String err2 = (String) request.getAttribute("error2");
	        if (err2 != null) {
	    %><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err2); %></span></p><%}%>
	    <%
	        String err3 = (String) request.getAttribute("error3");
	        if (err3 != null) {
	    %><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err3); %></span></p><% }%>
	    <%
	        String err4 = (String) request.getAttribute("error4");
	        if (err4 != null) {
	    %><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err4); %></span></p><% }%>
	    <%
	        String err5 = (String) request.getAttribute("error5");
	        if (err5 != null) {
	    %><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err5); %></span></p><% }%>
	<%
	        String err6 = (String) request.getAttribute("error6");
	        if (err6 != null) {
	    %><p style="background:url(img/not-available.png) no-repeat;color:red;"><span style="margin-left:21px;"><%out.print(err6); %></span></p><% }%>
    
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