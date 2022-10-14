<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<title>Insert title here</title>
</head>
<body>


<jsp:include page="Header_User.jsp"></jsp:include>
		
<form action="Update_Acc" method="post" enctype="multipart/form-data">
	<label for="image"><b>Thay ảnh diện</b></label>
    <input type="file" name="image" size="50" /><br/>
    <label for="username"><b>Tên đăng nhập</b></label><br>
    <input type="text"  name="username" value = "${sessionScope.user.username}" disabled="disabled"><br>

    
    <label for="name"><b>Tên hiển thị</b></label><br>
    <input type="text"  name="name" value = "${sessionScope.user.name}"><br>

    <label for="psw"><b>Mật khẩu</b></label><br>
    <input type="password"  name="pass"><br>

    <label for="psw-repeat"><b>Nhập lại mật khẩu</b></label><br>
    <input type="password"  name="repass"><br>
    
    <label for="email"><b>Email:</b></label><br>
    <input type="text"  name="email" value = "${sessionScope.user.email}"><br>
    
    <label for="phone"><b>SĐT:</b></label><br>
    <input type="text"  name="phone" value = "${sessionScope.user.phone}"><br>

    <div class="clearfix">
      <button type="submit" class="signupbtn">Chấp nhận</button>
    </div>
</form>
</body>
</html>