<%@ page language="java" contentType="text/html"; charset="utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<% %>
<meta charset="utf-8">
<title>Contents of ${dto.getBoardTitle}</title>
</head>
<body>
<div>
    <c:set var="dto" value="${Cont}"/>
    <table>
    <th><h3>Details of ${dto.getBoardWriter}</h3></th>
    <tr><td>Views: ${dto.getBoardHit()}, Written at: ${dto.getBoardWdate()} </td>
    <c:if test="${!empty dto.getBoardEdate()}">
    <td>Edited at: ${dto.getBoardEdate()}</td>
    </c:if>
    </tr>
    <tr>
    <tr>body:
    <td>${fn:replace(dto.getBoardCont()) "\n" "<br>"}</td>
    </tr>
    </table>
</div>
<div>
    <input type="button" value="글수정"
        onclick="location.href='boardInsert?no=${dto.getBoardNo() }&page=${curPage}'">
        &nbsp;&nbsp;

    <input type="button" value="글삭제"
        onclick="if(confirm('게시글을 정말 삭제하시겠습니까?')) {
                    location.href='boardDelete?no=${dto.getBoardNo() }&page=${curPage}'
                } else { return; }">
        &nbsp;&nbsp;            

    <input type="button" value="전체목록"
        onclick="location.href='list?page=${curPage}'">
</div>
</body>
</html>