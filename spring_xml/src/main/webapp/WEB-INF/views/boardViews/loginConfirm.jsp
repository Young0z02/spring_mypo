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
	<h2> 로그인 완료 </h2>
	<hr>
	<form action="memberList.do" method="post"> 
		<table border="1px solid gray" style="border-collapse:collapse;">			
			<tr align="center" height="50">
				<td width="200">로그인에 성공하셨습니다 </td>	
			</tr>
			<tr align="center" height="50">
				<td colspan="2">
					<input type="submit" value="확인">		
				</td>		
			</tr>
		</table>
	</form>

</body>
</html>