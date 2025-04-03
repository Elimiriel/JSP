<%@ page language="java" contentType="text/html"; charset="utf-8" taglib prefix="c" %>
<!doctype html>
<head>
<meta charset="utf-8">
<title>
List
</title>
</head>
<body>
<div>
<table>
<tr>
<th>No</th><th>Name</th><th>Title</th><th>Hits</th><tr>Written at</tr><th>Edited at</th>
</tr>
<c:set var="list" value="${list}"/>
<c:if test="${!empty list}">
    <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.getBoardNo()}</td>
            <td>${dto.get}</td>

            <td><input type="button" value="Detail" onclick="Location.href='content?num=${dto.getBoardNo()}'"</td>
        </tr>
    </c:forEach>
</c:if>
<c:if test="${empty list}">
    <tr>
    <td>
        <h4>No items</h4>
    </td>
    </tr>
    <tr>
    <td><input type="button" value="Add New" onclick="location.href='"</td>
    </tr>
</table>
</div>
</body>
</html>