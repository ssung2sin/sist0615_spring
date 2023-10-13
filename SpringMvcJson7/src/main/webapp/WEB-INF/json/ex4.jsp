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
	<h3 class="alert alert-success">Ex4번 예제</h3>
	<br>
	<h4>메뉴명을 입력후 엔터를 쳐주세요</h4>
	<input type="text" id="search" class="form-control" style="width: 150px;">
	<br><br>
	<h2 id="fname"></h2>
	<img alt="" src="" id="photo">
	
<script type="text/javascript">
	$("#search").keydown(function(key) {
		var name=$(this).val();
		if(key.keyCode==13) {
			$.ajax({
				type:"get",
				url:"list4",
				dataType:"json",
				data:{"name":name},
				success:function(data){
					$("#photo").attr("src","image/avata/"+data.photo);
					$("#fname").html(data.name);
				}
			})
		}
	});
</script>
</body>
</html>