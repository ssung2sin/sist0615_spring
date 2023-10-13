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
<h3>ex3번 예제</h3>
<br>
<button type="button" id="btn3" class="btn btn-outline-warning">list3 json 배열</button>
<div id="out3"></div>


<script type="text/javascript">
	$("#btn3").click(function(){
		
		$.ajax({
			type:"get",
			url:"list3",
			dataType:"json",
			success:function(data){
				
				var s="";
				
				$.each(data,function(i,elt){
					s+="<figure>";
					s+="<img src='image/avata/"+elt.photo+"' width=100>";
					s+="<figcaption><b>"
					s+=elt.name;
					s+="</b></figcaption>"
					s+="</figure>";
				})
				$("#out3").html(s);
			}
		})
	})
</script>
</body>
</html>