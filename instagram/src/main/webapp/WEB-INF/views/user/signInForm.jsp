<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
</head>


<body class="main_Form">
	<div class="main_Page">
          <div class="form">
            <img src="${pageContext.request.contextPath}/resources/img/title.png" alt="instagram title img">

            <form class="sign_Form" action="/signIn.do" method="POST">
              <input type="text" placeholder="이메일" name="user_email"/>
              <input type="password" placeholder="비밀번호" name="user_pw"/>
              <button>로그인</button>
              <div class="hr-sect">또는</div>

              <div class="kakaoLogin" style="text-align: center">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/kakao.png" alt="카카오로고"></a>
              </div>
              
              <c:if test="${resultMav == 'fail'}">
	              <div>
	              	<span>로그인이 실패했습니다.</span>
	              </div>
              </c:if>
              
              <p id="forgot_PW" style="text-align: center;"><a href="#">비밀번호를 잊으셨나요?</a></p>
              <div class="hr-sect"></div>
              <p id="signUp_signIn" style="text-align: center;">계정이 없으신가요? <a href="/user/signUpForm">가입하기</a></p>
            </form>
          </div>
        </div>

</body>
</html>