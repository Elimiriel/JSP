<@ page language="java" contentType="text/html"; charset="utf-8"@>
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
<h3>SU: ${SU}</h3>
${setAttribute("Name", SU)}
<h3><input type="button" onclick="${getRequestDispacher("ex02").forward(request, response)}"</h3>
</div>
</body>
</html>