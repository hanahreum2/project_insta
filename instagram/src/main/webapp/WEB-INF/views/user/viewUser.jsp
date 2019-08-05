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
<form action="<%=request.getContextPath()%>/updateUser.do"method="POST">
<input name="user_email" value="${vo.user_email }" readonly="readonly">
<p><input name="user_name" value="${vo.user_name }" />

<input type="submit" value="수정">
</form>
</body>
</html>