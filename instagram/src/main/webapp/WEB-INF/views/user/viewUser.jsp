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
<form action="/updateUser.do" method="POST">
	<input type="hidden" name="user_id" value="${user.user_id }" readonly="readonly">
	<input name="user_email" value="${user.user_email }" readonly="readonly">
	<p><input name="user_name" value="${user.user_name }" />
	
	<input type="submit" value="수정">
</form>
</body>
</html>