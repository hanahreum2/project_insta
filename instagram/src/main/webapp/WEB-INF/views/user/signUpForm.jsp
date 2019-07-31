<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<jsp:include page="../common/header.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/signUpForm.js"></script>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
</head>




<body class="main_Form">
	<div class="main_Page">
          <div class="form">
            <img src="${pageContext.request.contextPath}/resources/img/title.png" alt="instagram title img">

            <form:form class="sign_Form" modelAttribute="userVO" action="/signUp.do" method="post">
              <form:input type="text" path="user_email" id="user_email" name="user_email" placeholder="E-MAIL" />
              <form:errors cssStyle="color: red; font-size: 10px;" path="user_email" />
             
              <button type="button" value="중복확인" onclick="check_email();" ></button>
              
              <p class="result">
              	<span class="msg"></span>
              </p>
              
              <form:input type="text" path="user_name" id="user_name" name="user_name" placeholder="사용자 이름" />
              <form:errors cssStyle="color: red; font-size: 10px;" path="user_name" />
              
              <form:input type="password" id="user_pw" path="user_pw" name="user_pw" placeholder="비밀번호"/>
              <form:errors cssStyle="color: red; font-size: 10px;" path="user_pw" />
              
              <div id="result1"></div>
              
              <form:input type="password" id="user_check_pw" path="user_check_pw" name="user_check_pw" placeholder="비밀번호 확인"/>
              <form:errors cssStyle="color: red; font-size: 10px;" path="user_check_pw" />
              
              <button id="submit_btn">회원가입</button>
              
              <div class="hr-sect">또는</div>

              <div class="kakaoLogin" style="text-align: center">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/kakao.png" alt="카카오로고"></a>
              </div>
              
              <div class="hr-sect"></div>
              <p class="signUp_signIn" style="text-align: center;">계정이 있? <a href="/user/signInForm">로그인하기</a></p>
            </form:form>
          </div>
        </div>
        
        
        <!-- 커밋ㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱㄱ -->

</body>
</html>