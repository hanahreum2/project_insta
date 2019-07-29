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
<h1>회원목록</h1>
<table border="1">
<tr>
	<th>이메일</th>
	<th>이름</th>
	<th>가입날짜</th>
</tr>
<c:forEach var="list" items="${list }">

<tr>
	<td>${list.user_email }</td>
	<td>${list.user_name }</td>
	<td>${list.user_rdate }</td>
</tr>

</c:forEach>



</table>
</body>
</html>