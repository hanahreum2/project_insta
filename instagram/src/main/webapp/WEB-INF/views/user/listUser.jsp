<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/header.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<table border="1">
<tr>
	<th>id</th>	
	<th>이메일</th>
	<th>이름</th>
</tr>

<c:forEach var="list" items="${list }">
<tr>
	<td><a href="${path}/viewUser.do?user_id=${list.user_id }">${list.user_id }</a></td>
	<td>${list.user_email }</td>
	<td><a href="${path}/delUser.do?user_name=${list.user_name }">${list.user_name }</a></td>
	

</tr>
</c:forEach>

</table>
	
	
	
</body>
</html>