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
	$("#file").on("change", handleImgFileSelect);
	
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

<form action="/fileUpload" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
<div>
	<input type="file" name="file" id="file">
</div>

<div>
	<div class="img_wrap">
		<img width="100px" height="100px" id = "img" />
	</div>

</div>

이름 : <input type="text" name="name" id="cmd" value="namevla"><br>
<input type="submit" name="업로드" value="제출"><br>

        
        
        
    </form>



</body>
</html>