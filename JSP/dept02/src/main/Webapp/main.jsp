<%@ language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<Student> list = (List<Student>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
    <h1>부서 전체 정보</h1>
    <table border="1">
        <tr>
            <th>부서번호</th>
            <td></td>
            <th>부서명</th>
            <th>부서위치</th>
            <th>수정 및 삭제</th>
        </tr>
        <%
            for(Student dto : list) {
                dto=(Student) request.getAttribute("dto");
                %><tr><%
                for(dto.getDeptno() : list) {
                    %><td><%=dto.getDeptno()%></td><%
                    %><td><%=dto.getDname()%></td><%
                    %><td><%=dto.getLocation()%></td><%
                }
            }%>
            <tr><td><a href="view/update.jsp">수정</a> | <a href="view/delete.jsp">삭제</a></td></tr>
    </table>
</div>
</body>
</html>