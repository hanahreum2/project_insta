function check_email() {
	var data = $("#user_email").val();
	
	var pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

	//이메일 형식이 잘못됐을경우
	if(pattern.test(data)==false){
		$(".result .msg").text("형식이 올바르지 않습니다");
		$(".result .msg").attr("style","color:red");
		$("#user_email").focus();
		return false;
	
	}

	$.ajax({
		url : "/check_email.do",
		type : "post",
		data : data,
		success : function(data){
			if(data > 0) {
				$(".result .msg").text("사용불가");
				$(".result .msg").attr("style","color:red");
			}else {
				$(".result .msg").text("사용가능");
				$(".result .msg").attr("style","color:blue");
			}
		}
		
	}); //ajax
};
