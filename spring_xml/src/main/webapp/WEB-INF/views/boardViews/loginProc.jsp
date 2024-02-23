<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 하나의 게시판 내용 보기 </h2>
	<hr>
	<table border="1px solid gray" style="border-collapse:collapse;">
		<tr align="center" height="50">
			<td width="200">글제목 </td>
			<td width="200"> ${board.id} </td>			
		</tr>
		<tr align="center" height="50">
			<td width="200">글작성자 </td>
			<td width="200"> ${board.password} </td>			
		</tr>
	</table>
</body>
</html>