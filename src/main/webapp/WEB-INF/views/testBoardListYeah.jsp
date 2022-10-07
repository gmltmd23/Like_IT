<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: heeseung
  Date: 2022-10-07
  Time: 오후 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>테스트 게시판 목록</title>
    <style>
        table {
            width: 100%;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        table th {
            border: 1px solid #444444;
            text-align: center;
            height: 40px;
            background-color: dodgerblue;
            color: cornsilk;
        }
        table td {
            border: 1px solid #444444;
            text-align: center;
        }
    </style>
</head>
<body>
    <div style="text-align: center;">
        <h1>게시판 목록</h1>
        <table style="width: 700px; margin: auto">
            <tr>
                <th style="width: 10%">번호</th>
                <th style="width: 50%">제목</th>
                <th style="width: 15%">작성자</th>
                <th style="width: 15%">등록일</th>
                <th style="width: 10%">조회수</th>
            </tr>
            <c:forEach var="element" items="${boardBoard}">
                <tr>
                    <td>${element.id}</td>
                    <td><a href="getBoard?id=${element.id}">${element.title}</a></td>
                    <td>${element.writer}</td>
                    <td><fmt:formatDate value="${element.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${element.watchCount}</td>
                </tr>>
            </c:forEach>
        </table>
        <a href="insertBoard">새글 등록</a>
    </div>
</body>
</html>
