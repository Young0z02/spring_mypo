<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 로그인 </h2>
	<hr>
	<form action="loginProc.do" method="post"> 
		<table border="1px solid gray" style="border-collapse:collapse;">			
			<tr align="center" height="50">
				<td width="200">아이디 </td>
				<td width="200"> 
					<input type="text" name="id">
				</td>			
			</tr>
			<tr align="center" height="50">
				<td width="200">비밀번호 </td>
				<td width="200">  
					<input type="text" name="password">
				</td>			
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