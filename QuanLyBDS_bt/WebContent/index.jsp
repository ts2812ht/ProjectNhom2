<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<div>Tìm kiếm</div>
	<form action="SearchPost" method="post">
		<input type="text" name="Category_search" placeholder="Category"> <br> 
		<input type="text" name="District_search" placeholder="Quận/Huyện"><input type="text" name="Phuongxa_search" placeholder="Phường/xã"><br> 
		<input type="text" name="PriceLow_search" placeholder="Giá từ"> 
		<input type="text" name="PriceHigh_search" placeholder="Đến"><br> 
		<input type="text" name="AreaLow_search" placeholder="Diện tích từ">
		<input type="text" name="AreaHigh_search" placeholder="Đến"><br><br> 
		<input type="submit" value="Tìm">
	</form>
	<div>
		<img src="images/search.png" width="50" height="50" alt="image 1"/>
	</div>

	<div>
		<c:forEach items="${list}" var="o">

			<div class="post_box">
				<h2>
					<a href="MainPost_servlet?Pid=${o.id}">${o.title} :</a>
				</h2>
				<div>Posted on: ${o.create_at}</div>
				<div class="image_wrapper">
					<a href="#"><img src=${o.images } alt="image 1" /></a>
				</div>
				<p align="justify">${o.description}
					<a href="#" class="continue">Đọc tiếp ...</a>
				</p>
			</div>
		</c:forEach>

	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
