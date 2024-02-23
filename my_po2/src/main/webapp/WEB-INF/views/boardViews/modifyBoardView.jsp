<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피드백 내용 수정</title>
<!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
    body {
        background-color: #f8f9fa;
        padding: 20px;
    }

    h2 {
        color: #007bff;
    }

    form {
        margin-top: 20px;
    }

    table {
        border: 1px solid gray;
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 10px;
        border: 1px solid #ddd;
        text-align: center;
    }

    input[type="text"], input[type="submit"], input[type="button"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        display: inline-block;
        border: 1px solid #ced4da;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    input[type="button"] {
        background-color: #007bff;
        color: #ffffff;
        border: none;
        cursor: pointer;
    }

    input[type="button"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <h2>피드백 내용 수정</h2>
    <hr> 
    <form action="modifyProcBoard.do?seq=${board.seq}" method="post"> 
        <table>
            <tr>
                <th width="200">번호</th>
                <td width="200">${board.seq}</td>            
            </tr>       
            <tr>
                <th width="200">글작성자</th>
                <td width="200">${board.id}</td>            
            </tr>
            <tr>
                <th width="200">글제목</th>
                <td width="200">
                    <input type="text" value="${board.title}" name="title">
                </td>            
            </tr>
            <tr>
                <th width="200">글내용</th>
                <td width="200">
                    <input type="text" value="${board.content}" name="content"> 
                </td>            
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정하기">
                    <input type="button" value="목록보기" onclick="location.href='memberList.do'">            
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
