<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function() {
			var d = $("form").serialize();
			
			$.ajax({
				url : "member_search_ajax.jsp",
				data : d,
				type: "get",
				dataType : "json",
				success:function(r){
					var tag = "";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>"+r[i].id+"</td>";
						tag += "<td>"+r[i].pass+"</td>";
						tag += "<td>"+r[i].name+"</td>";
						tag += "<td>"+r[i].age+"</td>";
						tag += "<td>"+r[i].gender+"</td>";
						tag += "<td>"+r[i].address+"</td>";
						tag += "</tr>";
					}
					$("tbody").html(tag);
				}
			});
		});
	});
</script>
</head>
<body>
	<form>
		<select name="kind">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="gender">성별</option>
		</select>
		<input type="text" name="search" placeholder="검색어를 입력하세요"> 
		<button type="button">검색</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>암호</th>
				<th>이름</th>
				<th>나이</th>
				<th>성별</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
		<!-- ajax 결과가 추가될 영역	 -->
		</tbody>
	</table>
</body>
</html>











