<%@ page language="java" contentType="text/html"; charset="utf-8"@%>
${
request.setCharacterEncoding("utf-8");

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
<table>
<tr>
<th>ID</th><td>${param.ID}</td>
<tr><th>Name</th><td>${param.name}</td>
</tr>
<tr>
<th>Age</th><td>${param.Age}</td>
</tr>
<tr>
<td>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>