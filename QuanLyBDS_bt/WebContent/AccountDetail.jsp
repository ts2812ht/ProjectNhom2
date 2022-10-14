<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Insert title here</title>
</head>
<body>

<form action="Acount" method="post" enctype="multipart/form-data">
    <h1>Avatar</h1>
    <input type="file" name="image" size="50" /><br/>
    <label for="username"><b>Tên đăng nhập</b></label><br>
    <input type="text"  name="username" disabled="disabled"><br>

    
    <label for="name"><b>Tên hiển thị</b></label><br>
    <input type="text"  name="name"><br>

    <label for="psw"><b>Mật khẩu</b></label><br>
    <input type="password"  name="pass"><br>

    <label for="psw-repeat"><b>Nhập lại mật khẩu</b></label><br>
    <input type="password"  name="repass"><br>
    
    <label for="email"><b>Email:</b></label><br>
    <input type="text"  name="email"><br>
    
    <label for="phone"><b>SĐT:</b></label><br>
    <input type="text"  name="phone"><br>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Chấp nhận</button>
    </div>
</form>
</body>
</html>