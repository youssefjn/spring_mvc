<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Teams Management</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
	<div>
		<form action="/teams/edit" method="get">
			<table>
				<tr>
					<td>REF</td>
					<td><input type="text" name="ref" value="${idTeam}" readonly /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="${name}" /></td>
				</tr>
				<tr>
					<td>Budget</td>
					<td><input type="text" name="budget" value="${budget}" /></td>
				</tr>
				<tr>
					<td><input type="hidden" name="mc" value="${motCle}" /></td>
					<td><input type="hidden" name="edit" value="1" /></td>
				</tr>
				<tr>
					<td><input type="submit" name="action" value="save" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>