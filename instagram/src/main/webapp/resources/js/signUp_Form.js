function check_email() {
	
	var email_data = $("#user_email").val();
	
	var pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	//이메일 형식이 잘못됐을경우

	if(pattern.test(email_data) == false || email_data ==""){
		$(".result .msg").text("형식이 올바르지 않습니다");
		$(".result .msg").attr("style","color:red");
		$("#user_email").focus();
		$("#submit_btn").attr('disabled', true);
		return false;
	
	}

	$.ajax({
		url : "/check_email.do",
		type : "post",
		data : email_data,
		dataType : "json",
		contentType: "application/json; charset=UTF-8",
		success : function(data){			
			if(data == 0) {
				$(".result .msg").text("사용가능");
				$(".result .msg").attr("style","color:blue");
				$("#submit_btn").attr('disabled', false);
			
			}else {
				$(".result .msg").text("중복 이메일");
				$(".result .msg").attr("style","color:red");
				$("#user_email").focus();
				$("#submit_btn").attr('disabled', true);
			}
		}
		
	}); //ajax
	
};

$(document).ready(function(){
	$("#user_name").keyup(function(event){
		var input_name =$(this).val();
		var check_name = /^[A-Za-z가-힣]{2,20}$/; //이름 유효성 검사 2~4자 사이
		
		if(!check_name.test(input_name) || input_name == ""){
			$(".result2 .msg2").text("한글 영어만 가능");
			$(".result2 .msg2").attr("style","color:red");
			$("#user_name").focus();
			$("#submit_btn").attr('disabled', true);
			
		}else {
			$(".result2 .msg2").text("");
			$("#submit_btn").attr('disabled', false);
		}
		
	});
});






$(document).ready(function(){
	$("#user_pw").keydown(function(event){
		var input_pw =$(this).val();
		var check_pw = /^[A-Za-z0-9]{4,12}$/;


		if(!check_pw.test(input_pw) || input_pw==""){
			$(".result1 .msg1").text("영어랑 숫자랑 3~10");
			$(".result1 .msg1").attr("style","color:red");
			$("#user_pw").focus();
			$("#submit_btn").attr('disabled', true);
		
		}else {
			$(".result1 .msg1").text("");
			$("#submit_btn").attr('disabled', false);
			
		}
		

	});
});