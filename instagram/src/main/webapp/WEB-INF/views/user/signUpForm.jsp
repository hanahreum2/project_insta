<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
</head>


<body class="main_Form">
	<div class="main_Page">
          <div class="form">
            <img src="${pageContext.request.contextPath}/resources/img/title.png" alt="instagram title img">

            <form class="sign_Form" action="/signUp.do" method="post">
              <input type="text" id="user_email" name="user_email" placeholder="E-MAIL"/>
              <input type="text" id="user_name" name="user_name" placeholder="사용자 이름"/>
              <input type="password" id="user_pw" name="user_pw" placeholder="비밀번호"/>
              <input type="password" id="user_check_pw" name="user_check_pw" placeholder="비밀번호 확인"/>
              <button>회원가입</button>
              
              <div class="hr-sect">또는</div>

              <div class="kakaoLogin" style="text-align: center">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/kakao.png" alt="카카오로고"></a>
              </div>
              
              <div class="hr-sect"></div>
              <p class="signUp_signIn" style="text-align: center;">계정이 있? <a href="/user/signInForm">로그인하기</a></p>
            </form>
          </div>
        </div>

</body>
</html>