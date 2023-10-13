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
<form action="read1" method="post">
	<table class="table table-bordered" style="width: 300px;">
		<tr>
			<th wid>이름</th>
			<td><input type="text" class="form-control" name="name" style="width:100px;"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="남자" checked>남자
				&nbsp;&nbsp;
				<input type="radio" name="gender" value="여자">여자	
			</td>
		</tr>
		<select name="addr" class="form-control" style="width: 100px;">
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="대구">대구</option>
					<option value="부산">부산</option>
					<option value="제주">제주</option>
				</select>
		<tr>
			<td colspan="2" align="center"><button type="submit" class="btn btn-outline-success">서버에 전송</button></td>
		</tr>
	</table>
</form>
</body>
</html>