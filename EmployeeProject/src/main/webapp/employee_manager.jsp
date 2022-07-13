<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 관리 페이지</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	nav, section{
		width:1200px;
		margin:0 auto;
	}
	nav *{
		margin:20px 0px;
	}
	table{
		margin:0 auto;
		margin-top:20px;
		
	}
	section p{
		text-align:center;
	}
	td,th{
		padding:10px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	function delete_employee(obj){
		//alert($(obj).parent().parent().find("input[name=eno]").val());
		var d = "eno="+$(obj).parent().parent().find("input[name=eno]").val();
		location.href="delete.do?"+d;
	}
	function update_employee(obj){
		
	}
	$(function() {
		$(".update").click(function(){
			update_employee($(this));
		});
		$(".delete").click(function(){
			delete_employee($(this));
		});
		
	});
</script>
</head>
<body>
<c:choose>
	<c:when test="${dto.position > 3 && dto.dept == '인사' }">
		<nav>
			<h2>인사관리 시스템에 로그인 하셨습니다.</h2>
			<p>로그인 정보 : ${dto.name }
				<c:choose>
					<c:when test="${dto.position == 4 }">과장</c:when>
					<c:when test="${dto.position == 5 }">차장</c:when>
					<c:when test="${dto.position == 6 }">부장</c:when>
					<c:when test="${dto.position == 7 }">사장</c:when>
				</c:choose>
				<a href="logout.do">로그아웃</a>
			</p>
		</nav>
		<section>
			<table>
				<thead>
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>부서</th>
						<th>직급</th>
						<th>연봉</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${sessionScope.list }">
						<tr>
							<td>${e.eno }
								<input type="hidden" name="eno" value="${e.eno }">
							</td>						
							<td>
								<input type="text" name="name" value="${e.name }">
							</td>
							<td>
								<input type="text" name="dept" value="${e.dept}">
							</td>
							<td>
								<select name="position">
									<c:forEach var="i" items="${sessionScope.position }" varStatus="j">
										<c:choose>
											<c:when test="${j.count == e.position }">
												<option value="${j.count }" selected>${i }</option>
											</c:when>
											<c:otherwise>
													<option value="${j.count }">${i }</option>
											</c:otherwise>
										</c:choose>
									
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="text" name="salary" value="${e.salary}">
							</td>
							<td>
								<a href="#" class="update">수정</a> / <a href="#" class="delete">삭제</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</c:when>
	<c:otherwise>
		권한이 없습니다. <a href="logout.do">로그아웃</a><br>
		관리자 모드는 인사과 과장 이상들만 접근하실 수 있습니다.
	</c:otherwise>
</c:choose>
</body>
</html>





