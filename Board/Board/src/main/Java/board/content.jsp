<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
BoardDTO board=(BoardDTO)request.getAttribute("Content");
%>
<!doctype html>
<head>
<meta charset="utf-8">
<title>
Detailed Doc info
</title>
</head>
<body>
<div>
<table>
<%
if(board!=null) {
    %>
    <tr>
    <th>No</th><td><%=board.getBoard_no()%></td>
    </tr>
    <tr>
    <th>Writter</th><td><%=board.getBoard_writer()%></td>
    </tr><tr>
    <th>Written</th><td><%=board.getBoard_wdate()%></td>
    </tr><tr>
    <th>Edited</th><td><%=board.getboard_edit()%></td>
    </tr><tr>
    <th>Viewed</th><td><%=board.getboard_hit()%></td>
    </tr><tr>
    <th>Content</th><td><%=board.getBoard_cont().replace("\r\n", "<br>")%></td><%--line change replacer--%>
    </tr>
    <%
}
%>
</table>
</div>
<br>
<div>
<input type="button" value="edit/delete" onclick="Location.href='/insert?no=board.getBoard_no()'">
</div>
</body>