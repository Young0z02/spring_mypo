<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 내용 보기</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        .feedback-item {
            margin-bottom: 40px;
        }

        .feedback-item h2 {
            color: #007bff;
        }

        .feedback-item p {
            color: #495057;
        }

        .btn-custom {
            background-color: #007bff;
            border-color: #007bff;
            color: #ffffff;
        }

        .btn-custom:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: #ffffff;
        }

        .button-container {
            margin-top: 20px;
            text-align: center;
        }

        .button-container input {
            margin: 0 5px;
        }
    </style>
</head>
<body>
    <h2>하나의 피드백 내용 보기</h2>
    <hr>

    <table>
        <tr>
            <th width="20%">번호</th>
            <td>${board.seq}</td>
        </tr>
        <tr>
            <th>글작성자</th>
            <td>${board.id}</td>
        </tr>
        <tr>
            <th>글제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th>글내용</th>
            <td>${board.content}</td>
        </tr>
        <tr>
            <td colspan="2" class="button-container">
                <input type="button" class="btn btn-custom" value="수정하기" onclick="location.href='modifyBoard.do?seq=${board.seq}'">
                <input type="button" class="btn btn-custom" value="삭제하기" onclick="location.href='deleteBoard.do?seq=${board.seq}'">
                <input type="button" class="btn btn-custom" value="목록보기" onclick="location.href='memberList.do'">
            </td>
        </tr>
    </table>
</body>
</html>
