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
<form action="result" method="post">
	<table class="table table-bordered" style="width: 500px;">
		<tr>
			<th wid>이름</th>
			<td><input type="text" class="form-control" name="name" style="width:100px;"></td>
		</tr>
		<tr>
			<th>좋아하는 색</th>
			<td><input type="color" class="form-control" name="color" style="width:80px;"></td>
		</tr>
		<tr>
			<th>취미</th>
			<td><input type="checkbox" value="축구" name="hobby">축구
			<input type="checkbox" value="롤" name="hobby">롤
			<input type="checkbox" value="발로란트" name="hobby">발로란트
			<input type="checkbox" value="메이플" name="hobby">메이플
			<input type="checkbox" value="아르테일" name="hobby">아르테일
			</td>
		</tr>
		<tr>
			<th>좋아하는 언어</th>
			<td>
				<select name="language">
					<option value="java">java</option>
					<option value="html">html</option>
					<option value="oracle">oracle</option>
					<option value="jsp">jsp</option>
					<option value="spring">spring</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit" class="btn btn-outline-success">서버에 전송</button></td>
		</tr>
	</table>
</form>
</body>
</html>