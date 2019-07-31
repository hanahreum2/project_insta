function check_email() {
	
	var email_data = $("#user_email").val();
	
	var pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
	//이메일 형식이 잘못됐을경우

	if(pattern.test(email_data)==false){
		$(".result .msg").text("형식이 올바르지 않습니다");
		$(".result .msg").attr("style","color:red");
		$("#user_email").focus();
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

//$(document).ready(function(){
//	$("#user_name").keyup(function(event){
//		if (!(event.keyCode >=37 && event.keyCode<=40)){
//			var result = "숫자야";
//			var preHtml = $("#result").html();
//			$("#result1").html(preHtml+ "<br />" +result);
//		}
//		
//		if($(this).val() ==""){
//			$("#result1").empty();
//		}
//	});
//
//});
$(document).ready(function(){
	$("#user_name").keydown(function(event){
		if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
		    var input_name = $(this).val();
		    $(this).val(input_name.replace(/[^(ㄱ-힣a-zA-Z)]/gi, ''));
		}
	});
});

$(document).ready(function(){
	$("#user_pw").keydown(function(event){
		var input_pw =$(this).val();
		var check_pw = /^.*(?=.{3,10})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

		if(!check_pw.test(input_pw)){
			var result_1 = "영문, 숫자 조합 3~10"
			$("#result1").html(result_1);
		
		}else {
			$("#result1").empty();
			
		}
		

	});
});