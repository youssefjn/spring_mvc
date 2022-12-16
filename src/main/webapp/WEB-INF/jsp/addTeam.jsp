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
		<form action="/teams/add" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>

				<tr>
					<td>Budget</td>
					<td><input type="text" name="budget" /></td>
				</tr>

				<tr>
					<td><input type="submit" name="action" value="save" /></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>