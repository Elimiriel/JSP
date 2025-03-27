<%@ language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
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
                %><td><input type="button" value="edit" 
                onclick="<a href location='<%=request.getContextPath()%>/update.jsp?deptno=<%=dto.getDeptno()%>'"> | 
                <input type="button" value="del" 
                onclick="<a href location='<%=request.getContextPath()%>/delete.jsp?deptno=<%=dto.getDeptno()%>'">
                </td>
                <%}%>
    </table>
    <div>
        <input type="button" value="update" 
                onclick="<a href location='<%=request.getContextPath()%>/update.jsp?deptno=<%=dto.getDeptno()%>'">
    </div>
    
</div>
</body>
</html>