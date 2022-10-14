<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="Header.jsp"></jsp:include>

<hr>
<form action="NewPost_servlet" method="post" enctype="multipart/form-data">
	<br>  
	 <label for="name"><b>Tên hiển thị(*):</b></label><br>
    <input type="text"  name="name"><br>
    
    
    <label for="Title"><b>Tiêu đề (<100 chữ):</b></label><br>
	<input type="text" name="Title" style="width:400px"> <br> <br>
	
	<label for="Category"><b>Category(*):</b></label><br>
	<input type="text" name="Category"> <br> <br>
	<label for="District"><b>Quận/Huyện(*):</b></label><br> 
	<input type="text" name="District"><br> 
	<label for="Phuongxa"><b>Phường/xã:</b></label><br>
	<input type="text" name="Phuongxa"><br> 
	<label for="Address"><b>Địa chỉ(*):</b></label><br>
	<input type="text" name="Address"><br> 
	<label for="Price"><b>Giá(*)</b></label><br>
	<input type="text" name="Price"> <br> <br>
	<label for="Area"><b>Diện tích(m2)(*)</b></label><br> 
	<input type="text" name="Area"><br><br>
	
	<label for="image"><b>Thêm ảnh</b></label>
    <input type="file" name="image" size="50" /><br/><br>
    
	
	<label for="Description"><b>Mô tả:</b></label><br>
	<input type="text" style="height:200px;width:400px" " name="Description"> <br> <br>
	
	<label for="Phone"><b>SĐT(*):</b></label><br>
	<input type="text" name="Phone"> <br> <br>
	

	<div class="clearfix">
		<button type="submit">Đăng bài</button>
	</div>
</form>
<jsp:include page="Footer.jsp"></jsp:include>