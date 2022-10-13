<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<c:forEach items="${list}" var="o" >
		
		<div class="post_box">
			<h2><a href="MainPost_servlet?Pid=${o.id}">${o.title} :</a></h2>		
			<div>Posted on: ${o.create_at}</div>
    		<div class="image_wrapper"><a href="#"><img src=${o.images} alt="image 1" /></a></div>
			<p align="justify">${o.description}  <a href="#" class="continue">Đọc tiếp ...</a></p>
		</div>
	</c:forEach>

</div>