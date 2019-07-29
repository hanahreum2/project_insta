<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>이메일</th>
	<th>이름</th>
	<th>가입날짜</th>
</tr>

<tr>
	<td>${vo.user_email }</td>
	<td>${vo.user_name }</td>
	<td>${vo.user_rdate }</td>
</tr>




</table>

</body>
</html>