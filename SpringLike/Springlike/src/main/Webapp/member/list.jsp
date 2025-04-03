<%@ page language="java" contentType="text/html"; charset="utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>List</title>
<link rel="stylesheet" type="text/css" href="/WEB-INF/lib/list">
</head>
<body>
<div>
<table>
<tr>
<th>No</th><th>Title</th><th>Writter</th><th>Hits</th><tr>Written at</tr><th>Edited at</th>
</tr>
<tr>
<c:set var="list" value="${list}"/>
    <c:if test="${!empty list}">
        <c:forEach items="${list}" var="dto">
            <tr>
            <td>${dto.getBoardNo()}</td>
            <td><a href="<%request.getContextPath()%>/content?no=${dto.getBoardNo()}&&page=${curPage}">${dto.getBoardTitle()}</a></td>
            <td>${dto.getBoardWriter()}</td>
            <td>${dto.getBoardHit()}</td>
            <td>${dto.getBoardWdate()}</td>
            <td>${dto.getBoardEdate()}</td>
            <td><input type="button" name="Edit" 
                    onclick="${request.setAttribute("Read"); FrontController;}"><input type="button" name="Delete" onclick=""></td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty list}">
    <tr>
        <td>No Contents</td>
    </tr>
    </c:if>
</tr>
</table>
</div>
<div>
<input type="button" name="Write" onclick=""><input type="button" name="Board Management" onclick="">
</div>
<div>
<%-- 페이징 처리 영역 --%>
<nav>
    <ul>
        <li>
            <a href="list?page=1">First</a>
        </li>
        <li>
            <a href="list?page=${page - 1 }">Previous</a>
        </li>
        
        <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
            <c:if test="${i == page }">
                <li><a href="list?page=${i }">${i }</a></li>
            </c:if>
            
            <c:if test="${i != page }">
                <li><a href="list?page=${i }">${i }</a></li>
            </c:if>
        </c:forEach>
        
        <c:if test="${endBlock < allPage }">
            <li> <a href="list?page=${page + 1 }">Next</a> </li>
        
            <li> <a href="list?page=${allPage }">End</a> </li>
        </c:if>
    </ul>
</nav>
</div>
</body>
</html>