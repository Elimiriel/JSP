<%@ page language="java" contentType="text/html"; charset="utf-8" taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" @%>
<!doctype html>
<head>
<meta charset="utf-8">
<title>
JSTL: tagged Java: c means core
</title>
</head>
<body>
<div>
    <c:set var="varname" value="value(int, float, String.... in autotypes)"></c:set>
    <c:out value="varname"/>
    <c:remove var="varname"/>
</div>
<div>
    <%--No else, choose=switch--%>
    <c:if test=True (actions)/>
    <c:choose>
        <c:when test="조건식1">
            조건식1이 참인 경우 실행 문장 </c:when>
        <c:when test="조건식2">
            조건식2이 참인 경우 실행 문장 </c:when>
        <c:when test="조건식3">
            조건식3이 참인 경우 실행 문장 </c:when>
        <c:otherwise>
            상기의 조건식 이외의 경우 실행 문장 </c:otherwise>
    </c:choose>
</div>
<div>
    <c:forEach begin="startvar" end="endval" step="by step" var="indvarname">
        (executes)
    </c:forEach>
    <c:forEach items="Objname" var="indvarname">
        (executes)
    </c:forEach>
</div>
</body>
</html>