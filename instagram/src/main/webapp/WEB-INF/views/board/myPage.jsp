<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>instagram - mypage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="main.css" />
    <script src="main.js"></script>
    <link rel="stylesheet" href="/resources/css/myPage.css?ver=1" type="text/css">

    <!-- font -->
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300" rel="stylesheet">

    <!-- bootstrap -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>

<body class="myPage">
    <div class="profile-container"> 

            <div class="nav-profile-img">
                <a href="#"><img src="profile.jpg"/></a>
            </div>

            <div class="nav-profile-text">
                <div class="nav-profile-text1"> 
                    songjjona 
                    <button class="nav-profile-button" onclick=""> 프로필 편집 </button>
                    <a href="#">
                        <img src="settings(1).png" id="nav-profile-text1-edit"/>
                    </a>
            </div>

            <div class="nav-profile-text2"> 
                <div class="nav-profile-text2-postcount">
                    <a href="#">post 0</a>
                </div>
                <div class="nav-profile-text2-follower">
                        <a href="#">Follower 0</a>
                </div>
                <div class="nav-profile-text2-block">
                        <a href="#">block 0</a>
                </div>
            </div>
 
            <div class="nav-profile-text3"> 송정아 </div>

        </div><!-- nav-profile-text end --> 

</div>  <!--profile-container end -->


    <div class="middle-menu">


        <div class="middle-menu-button">
            <input type="button" id="middle-menu-button-postview"></input>
            <input type="button" id="middle-menu-button-postupload"></input>
        </div> <!--middle-menu-button -->
    </div> <!-- middle-menu end -->


    <div class="photozone-container">
        <div class="row">  
            <div class="col-md-4">
                <div>
                    <div id="col-md-4:hover" style="position: absolute;">
                        <div style="position: relative; top: 120px; left: 76px;"><img src="favorite-heart-button.png"></img>
                    </div>
                </div>
                <img id="photo-position" src="momoyo.png"></img>
                </div>
            </div>


            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

            <div class="col-md-4">
                <img src="/resources/img/header/momoyo.png"/>
            </div><!-- col-md-4 end-->

        </div> <!-- row end-->

    </div> <!-- photozone-container end-->

</body>
</html>