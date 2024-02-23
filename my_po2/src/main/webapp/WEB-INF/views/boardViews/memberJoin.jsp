<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Your Name">
    <title>Registration</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .form-signin {
            max-width: 400px;
            padding: 15px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .form-floating {
            margin-bottom: 15px;
        }

        .form-floating label {
            color: #495057;
        }

        .form-floating input {
            border-radius: 8px;
            padding: 10px;
            border: 1px solid #ced4da;
        }

        .checkbox {
            font-weight: normal;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .btn-primary:focus {
            box-shadow: 0 0 0 0.25rem rgba(0, 123, 255, 0.5);
        }

        h1 {
            color: #007bff;
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/signin.css" rel="stylesheet"/>
</head>

<body>
<main class="form-signin">
    <form action="memberJoin.do" method="post">
        <h1 class="h3 mb-3 fw-normal">피드백 쓰기</h1>

        <div class="form-floating">
            <input type="text" class="form-control" id="id" name="id" required>
            <label for="id">닉네임</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" required>
            <label for="password">확인 번호</label>
        </div>
        <div class="form-floating">
           <input type="text" class="form-control" id="content" name="content" required>
           <label for="content">content</label>
       </div>
       <div class="form-floating">
           <input type="text" class="form-control" id="title" name="title" required>
           <label for="title">제목</label>
       </div>
		 <button class="w-100 btn btn-lg btn-primary">피드백 보내기</button>
		 <p></p>
		 <button class="w-100 btn btn-lg btn-primary" onclick="location.href='main.do'">메인 화면으로 돌아가기</button>

    </form>
</main>
</body>
</html>
