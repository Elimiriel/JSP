<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
List<BoardDTO> boardinfo=(List<BoardDTO>)request.getAttribute("List");
int listcount= (int)request.getAttribute("Count");
//data receive from DBDAO
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Table All table</title>
</head>
<body>
<div>
<table>
<tr>
<th>글번호</th> <th>title</th><th>Writter</th><th>reads</th><th>WDate</th>
</tr>
<%
JavaToHTML conctents=JavaToHTML.getAttribute();
conctents.markIO(boardinfo, html, table);
%>
</table>
<input type="button" name="Write" onclick="/content">
</div>
</body>
</html>