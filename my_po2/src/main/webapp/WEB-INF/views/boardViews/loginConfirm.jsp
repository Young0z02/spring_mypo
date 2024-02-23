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
    <title>Login</title>

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

        /* Add a success message style */
        .success-message {
            color: #28a745;
            margin-top: 15px;
        }
    </style>

    <!-- Custom styles for this template -->
    <link href="${path}/resources/css/signin.css" rel="stylesheet"/>
</head>

<body>

<main class="form-signin">
    <form action="main.do" method="post">
        <h1 class="h3 mb-3 fw-normal">Login 성공</h1>
        <button class="w-100 btn btn-lg btn-primary" onclick="location.href='${path}/main.do'">메인화면으로 가기</button>
        <p class="success-message">오류는 관리자에게 문의</p>
    </form>
</main>
</body>
</html>
