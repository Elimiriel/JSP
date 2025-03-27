<%@ language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import InsertSublet %>
<%
//
List<String> joblist=(List<String>)request.getAttribute("job");
List<EmpDTO> mgrlist=(List<EmpDTO>)request.getAttribute("mgr");
List<DeptDTO> deptlist=(List<DeptDTO)request.getAttribute("dept");
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Input into DB</title>
</head>
<body>
<div>
<table>
<tr>ID: </tr><td><input type="number" value="Input ID here" itemid=></td>
<tr>Name: </tr><td><input type="text" value="Input Name here"></td>
<tr>Job: </tr><td><select name="job"><%
    if(joblist.size()==0) {
        %><option value="N/A"></option><input type="text" value="Register Job Here"<%
    } else {
        %><option value="<%joblist.get()%>"<%
        }
%></td>
<tr>Manager: </tr><td><input type="search"></td>
<tr>Hired Date: </tr><td><input type="date"></td>
<tr>Salary: </tr><td><input type="text"></td>
<tr>Additional Commisions: </tr><td><input type="text"></td>
<tr>Department: </tr><td><input type="search" itemid="<%deptlist%>"></td>
</table>
</div>
</body>
</html>