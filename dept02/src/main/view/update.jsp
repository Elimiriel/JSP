<%@ language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
    <h1>부서 정보</h1>
    <form method="post" action="<%=request.getContextPath()%>/insertOK">
    <table border="1">
        <tr>
            <th>부서번호</th>
            <th>부서명</th>
            <th>부서위치</th>
        </tr>
        <tr>
            <td><input type="text" name="deptno"></td>
            <td><input type="text" name="dname"></td>
            <td><input type="text" name="location"></td>
        </tr>
        <tr>
            <td><input type="submit" value="추가"></td>
            <td><input type="reset" value="취소"></td>
        </tr>
    </table>
</div>
</body>