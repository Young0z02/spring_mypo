<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Feedback List</title>
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        .container {
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

        .btn-custom {
            background-color: #007bff;
            border-color: #007bff;
            color: #ffffff;
        }

        .btn-custom:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mt-4">전체 피드백 보기</h2>
        <hr>
        <a href="memberJoin.do">새로운 데이터 추가</a>

        <form id="searchForm" action="memberList.do" method="POST">
            <input type="text" name="keyword" placeholder="검색어를 입력하세요">
            <input type="hidden" name="sortOption" id="sortOptionInput" value="seq_asc">
            <select name="sortOption" onchange="updateSortOption(this)">
                <option value="seq_asc">seq (오름차순)</option>
                <option value="seq_desc">seq (내림차순)</option>
            </select>
            <input type="submit" value="검색 및 정렬" class="btn btn-primary">
        </form>

        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Seq</th>
                    <th scope="col">Id</th>
                    <th scope="col">Title</th>
                    <th scope="col">Content</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${bList}" var="board">
                    <tr>
                        <td>${board.seq}</td>
                        <td>
                            <a href="getBoard.do?seq=${board.seq}">${board.id}</a>
                        </td>
                        <td>${board.title}</td>
                        <td>${board.content}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- 페이징 부분 -->
        <div class="pagination">
            <c:if test="${totalPages > 1}">
                <c:choose>
                    <c:when test="${currentPage > 1}">
                        <a href="?page=${currentPage - 1}">&laquo; 이전</a>
                    </c:when>
                    <c:otherwise>
                        <a class="disabled">&laquo; 이전</a>
                    </c:otherwise>
                </c:choose>
                
                <c:forEach begin="1" end="${totalPages}" varStatus="page">
                    <c:choose>
                        <c:when test="${page.index == currentPage}">
                            <a class="active">${page.index}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="?page=${page.index}">${page.index}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <c:choose>
                    <c:when test="${currentPage < totalPages}">
                        <a href="?page=${currentPage + 1}">다음 &raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a class="disabled">다음 &raquo;</a>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </div>
    </div>

    <script>
        function updateSortOption(selectElement) {
            // 선택된 값 가져오기
            var selectedValue = selectElement.value;

            // 숨겨진 입력 필드의 값 설정
            document.getElementById('sortOptionInput').value = selectedValue;

            // 폼 제출
            document.getElementById('searchForm').submit();
        }
    </script>
</body>
</html>
