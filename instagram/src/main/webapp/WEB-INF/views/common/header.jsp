<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/user/signInForm">로그인 <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/listUser.do">회원목록</a>
      <a class="nav-item nav-link" href="#"> 로그아웃 </a>
      <a class="nav-item nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      ${login.user_email}님 로그인중
    </div>
  </div>
</nav>

</body>
</html>