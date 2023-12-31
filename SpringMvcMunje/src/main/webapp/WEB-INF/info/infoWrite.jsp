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

<div style="color:${dto.color}">
	이름 : ${dto.name }<br>
	색상 : <div style="width: 30px; height: 30px; background-color: ${dto.color}"></div><br>
	취미 :
	<c:if test="${empty dto.hobby }">취미없음<br></c:if>
	<c:if test="${!empty dto.hobby }">
		<c:forEach var="h" items="${dto.hobby }">
			[${h }]
		</c:forEach>
		<br>
	</c:if>
	언어 : ${dto.language }<br>
	
</div>
</body>
</html>