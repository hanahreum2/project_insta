<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">

var sel_file;


$(document).ready(function(){
	$("#input_img").on("change", handleImgFileSelect);
	
});

function handleImgFileSelect(e){
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	filesArr.forEach(function(f){
		if(!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능하다");
			return;
		}
		
		sel_file = f;
		
		var reader = new FileReader();
		reader.onload = function(e){
			$('#img').attr("src", e.target.result);
		}
		reader.readAsDataURL(f);
	});
}


</script>
<body>

<h1>글/사진 올리기</h1>

<form action="/img_write.do">
<div>
	<input type="file" name="input_img" id="input_img">
</div>

<div>
	<div class="img_wrap">
		<img width="100px" height="100px" id = "img" />
	</div>

</div>

<input type="text" name="test_text" id="test_text">
<button type="button" id="btn" onclick="btn_click();">전송</button>
</form>
</body>
</html>