<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 전체 게시판 데이터 보기 </h2>
	<hr>
	<a href="login.do"> 로그인 하기 </a>
	<table border="1px solid gray" style="border-collapse:collapse;">
		<tr align="center" height="50">
			<td width="200">번호 </td>
			<td width="200">아이디 </td>
			<td width="200">비밀번호 </td>
	
		</tr>
		<!-- jstl을 이용하여 데이터 출력 -->
		<c:forEach items="${bList}" var="board">
			<tr align="center" height="50">
				<td width="200">${board.seq} </td>
				<td width="200">
					<a href="getBoard.do?seq=${board.seq}">	${board.id}</a> 
				</td>
				<td width="200">${board.password} </td>
			</tr>		
		</c:forEach>
	</table>
	
	
	
</body>
</html>