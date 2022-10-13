<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

  <jsp:include page="Header.jsp"></jsp:include>
  <br><br><br>
  
  <form class="modal-content animate" action="Login" method="post">
    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="uname"><br>

      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw"><br>
        
      <button type="submit">Login</button>
    </div>
  </form>
  <br><br><br>
  <jsp:include page="Footer.jsp"></jsp:include>