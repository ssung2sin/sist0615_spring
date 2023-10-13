<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gaegu:wght@300&family=Nanum+Pen+Script&family=Sunflower:wght@300&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<button type="button" class="btn btn-outline-info"
onclick="location.href='writeform'">차량 정보 입력</button>
<c:if test="${totalCount==0 }">
	<h3 class="alert alert-info">저장된 차의 정보가 없습니다.</h3>
</c:if>
<c:if test="${totalCount>0 }">
	<h3 class="alert alert-info">${totalCount }개의 자동차가 등록되었습니다.</h3>
</c:if>
<hr>
<table class="table table-bordered" style="width: 700px;">
	<tr>
		<th style="width: 60px;">번호</th>
		<th style="width: 150px;">차량명</th>
		<th style="width: 100px;">차색상</th>
		<th style="width: 160px;">차량가격</th>
		<th style="width: 160px;">구입일</th>
		<th style="width: 150px;">편집</th>
	</tr>
	<c:forEach var="dto" items="${list }" varStatus="i">
	<tr align="center">
		<td>${i.count }</td>
		<td>${dto.carname }</td>
		<td>
			<div style="width: 30px; height: 30px; background-color: ${dto.carcolor };"></div>
		</td>
		<td><fmt:formatNumber value="${dto.carprice }" type="currency"/></td>
		<td>${dto.carguip }</td>
		<td>
			<button type="button" class="btn btn-outline-warning btn-sm"
			onclick="location.href='updateform?num=${dto.num}'">수정</button>
			<button type="button" class="btn btn-outline-danger btn-sm"
			onclick="location.href='delete?num=${dto.num}'">삭제</button>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>