<%@ page language="java" contentType="text/html"; charset="utf-8"@%>
${
int su=23;
pageContext.setAttribute("SU", su);
//pageContext type: local-cannot pass
}
<!doctype html>
<head>
<meta charset="utf-8">
<title>
EL language
</title>
</head>
<body>
<div>
<form method="post" action="ex05.jsp">
<table>
<tr>
<th>ID</th><td><input type="text" name="ID"></td>
<tr><th>Name</th><td><input type="text" name="name"></td>
</tr>
<tr>
<th>Age</th><td><input type="text" name="Age"></td>
</tr>
<tr>
<td>
<input type="button" name="submit" ><input type="reset" name="clear"> 
</td>
</tr>
</table>
</form>
</div>
</body>
</html>