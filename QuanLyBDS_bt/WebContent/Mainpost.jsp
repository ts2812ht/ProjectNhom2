<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<div>
	<h2>${post.title}</h2>
	<img src=${post.images} alt="image 1" />
	<div>${post.address}</div>
	<div>${post.price} triệu/tháng  Diện tích:${post.area}m2   Thời gian đăng: ${post.create_at}   </div>
	<h3>Thông tin mô tả</h3>
	<div>${post.description}</div>

</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
