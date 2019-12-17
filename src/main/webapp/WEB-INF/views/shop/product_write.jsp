<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- ckeditor 사용을 위해 js 파일 연결 -->
<script src="${path}/ckeditor/ckeditor.js"></script>

</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<script type="text/javascript">
function product_write(){
	var product_name=$("#product_name").val();
	var price=$("#price").val();
	var description=$("#description").val();
	if(product_name==""){//빈값이면
		//문자열 비교 : java는 a.equals(b), javascript는 a==b
		alert("상품이름을 입력하세요");
	    $("#product_name").focus(); //입력포커스 이동
	    return; //리턴값없이 함수 종료, 폼 데이터를 제출하지 않음
	}
	if(price=""){
		alert("가격을 입력하세요");
		$("#price").focus();
		return;
	}
	//폼 데이터를 받을 주소
	document.form1.action="${path}/shop/product/insert.do";
	//폼 데이터를 서버에 전송
	document.form1.submit();
}
</script>

<h2>옵션 등록</h2>
<form name="form1" method="post" 
enctype="multipart/form-data">
<table>
  <tr>
    <td>옵션명</td>
    <td><input name="product_name" id="product_name"></td>
  </tr>
  <tr>
    <td>가격</td>
    <td><input name="price" id="price"></td>
  </tr>
  <tr>
    <td>옵션설명</td>
    <td>
    <textarea rows="5" cols="60" 
    name="description" id="description"></textarea>
  <script>
  //id가 description인 태그에 ckeditor를 적용
  
  CKEDITOR.replace("description", {
	  filebrowserUploadUrl : "${path}/imageUpload.do"
  });
  </script>  
    </td>
  </tr>    
  <tr>
    <td>상품이미지</td>
    <td><input type="file" name="file1" id="file1"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="button" value="등록"
        onclick="product_write()">
      <input type="button" value="목록"
        onclick="location.href='${path}/shop/product/list.do'">  
    </td>    
  </tr>  
</table>
</form>
</body>
<%@ include file="../include/footer.jsp" %>
</html>