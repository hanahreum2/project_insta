<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>header</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    <link rel="stylesheet" href="/resources/css/header.css?ver=1" type="text/css">
</head>
<body class="header-body">
    <ul class="horizontal-menu">
        <li class="header-list"><a class="header-a" href="#"><img id="header-logo" src="/resources/img/header/header-logo.png"></a></li>
        <li class="header-list"><a class="header-a" href="#"><input type="text" id="header-search" placeholder="검색"></a></li>
        <li class="header-list"><a class="header-a" href="/user/signInForm"><img id="header-img" src="/resources/img/header/notification.png"></a></li>
        <li class="header-list"><a class="header-a" href="#"><img id="header-img" src="/resources/img/header/like.png"></a></li>
        <li class="header-list"><a class="header-a" href="/listUser.do"><img id="header-img" src="/resources/img/header/user.png"></a></li>
        
        <li class="header-list">
        <c:if test="${login != null}">
			<a class="header-a" href="/signOut.do"><img id="header-img" src="/resources/img/header/logout.png"></a>
        </c:if>
        </li>
        
        <li style="list-style-type: none;">
	        <c:if test="${login != null}">
	   			<c:out value="${login.user_email}님 로그인중" />
			</c:if>
		</li>


</ul>
</body>
</html>