<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css">
</head>


<body class="main_Form">
	<div class="main_Page">
          <div class="form">
            <img src="${pageContext.request.contextPath}/resources/img/title.png" alt="instagram title img">

            <form class="sign_Form">
              <input type="text" placeholder="이메일"/>
              <input type="password" placeholder="비밀번호"/>
              <button>로그인</button>
              <div class="hr-sect">또는</div>

              <div class="kakaoLogin" style="text-align: center">
                  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/kakao.png" alt="카카오로고"></a>
              </div>
              
              <p id="forgot_PW" style="text-align: center;"><a href="#">비밀번호를 잊으셨나요?</a></p>
              <div class="hr-sect"></div>
              <p id="signUp_signIn" style="text-align: center;">계정이 없으신가요? <a href="/user/signUpForm">가입하기</a></p>
            </form>
          </div>
        </div>

</body>
</html>