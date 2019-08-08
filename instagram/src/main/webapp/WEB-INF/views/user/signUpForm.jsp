<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script type="text/javascript" src="/resources/js/signUp_Form.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">

</head>


<body class="main_Form">
	<div class="main_Page">
          <div class="form">
            <!--  <img src="${pageContext.request.contextPath}/resources/img/title.png" alt="instagram title img">-->
            <form:form class="sign_Form" modelAttribute="userVO" action="/signUp.do" method="post">
              
              <form:input type="text" path="user_id" id="user_id" name="user_id" placeholder="ID" />
			  <button type="button" onclick="check_id()">중복</button>
             
              
              <p class="result"><span class="msg"></span></p>
              
              <form:input type="text" path="user_name" id="user_name" name="user_name" placeholder="사용자 이름" style="ime-mode:disabled;"/>
              <p class="result2"><span class="msg2"></span></p>
              
              <form:input type="password" id="user_pw" path="user_pw" name="user_pw" placeholder="비밀번호"/>
              <p class="result1"><span class="msg1"></span></p>
              
             <!--  <div id="result1"></div> -->
              
              <form:input type="password" id="user_check_pw" path="user_check_pw" name="user_check_pw" placeholder="비밀번호 확인"/>
              <form:errors cssStyle="color: red; font-size: 10px;" path="user_check_pw" />
              
              <form:input type="email" path="user_email" id="user_email" name="user_email" placeholder="E-MAIL" />
              
              
              
              <button id="submit_btn" type="submit">회원가입</button>
              
              <div class="hr-sect">또는</div>

              <div class="kakaoLogin" style="text-align: center">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/kakao.png" alt="카카오로고"></a>
              </div>
              
              <div class="hr-sect"></div>
              <p class="signUp_signIn" style="text-align: center;">계정이 있? <a href="/user/signInForm">로그인하기</a></p>
            </form:form>
          </div>
        </div>
        
<jsp:include page="../common/footer.jsp"></jsp:include>