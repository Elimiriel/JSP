<%@ page language="java" contentType="text/html"; charset="utf-8" taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<head>
<meta charset="utf-8">
<title>
EL language Page Main!
</title>
<c: set="${FrontController(table, ArrayList<String> adminlist)}">
</head>
<body>
<div>
<table>
<th>Active Boards:</th>
<c:if test="${!empty adminlist}">
    <c:forEach items="${tables}" var="adminlist">
    <tr><td>${dto.}</td>
    </tr>
</c:if>
</table>
<h3><input type="button" onclick="${getRequestDispacher()}">: ${RequestScope.SU}</h3>
</div>
<div>
<script type="text/javascript"></script>
</div>
<div>
<a href="<%request.getContextPath()%>/list">[전체 게시글 목록]</a>
</div>
</body>
</html>