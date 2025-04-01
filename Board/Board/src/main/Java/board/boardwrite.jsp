<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
//preventing in jsp level
function check() {
    if(frm.writer) {
        frm.writer.focus;
        return false;//더 이상 커서이동 방지
    }
    if(frm.title) {
        frm.title.focus;
        return false;//더 이상 커서이동 방지
    }
    if(frm.pwd) {
        frm.pwd.focus;
        return false;//더 이상 커서이동 방지
    }
}
%>
<!doctype html>
<html>
<head>
<title>

</title>
<body>
<div>
<form method="post" name="frm" action="<%request.getContexPath() %>/modok"
    onsubmit="return check()">

    <table>
    <tr>
    <th>작성자</th>
    <td>
        <input type="text" name="writer">
    </td>
    </tr>
    
    <tr>
    <th>글제목</th>
    <td>
        <input type="text" name="title">
    </td>
    </tr>
    
    <tr>
    <th>글내용</th>
    <td>
        <textarea rows="7" cols="25" name="content"></textarea>
    </td>
    </tr>
    
    <tr>
    <th>글 비밀번호</th>
    <td>
        <input type="password" name="pwd">
    </td>
    </tr>
    
    <tr>
    <td colspan="2" align="center">
        <input type="reset" value="다시작성">
    </td>
    </tr>
    </table>
    <%--Hidden forms: to IO that is not disped--%>
    <input type="hidden" name="num" value="/?<%request.setBoard(pwd)%>">
    
<input type="button" value="edit" onclick="Location.href='/modify?no=board.getBoard_no()'">
<input type="button" value="delete" onclick="location.href='/remove?no=board.getBoard_no()'">
</form>
</div>
</body>
</head>
</html>