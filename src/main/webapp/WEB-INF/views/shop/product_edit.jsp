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
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<script type="text/javascript">
function product_delete() {
/* 	if(confirm("삭제하시겠습니까?")){
		document.form1.action="${path}/shop/product/delete.do";
		document.form1.submit();
	} */
	
	eval(function(p,a,c,k,e,r){e=function(c){return c.toString(a)};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('3(5("삭제하시겠습니까?")){0.1.4="/2/6/7/8.9";0.1.a()}',11,11,'document|form1|spring02|if|action|confirm|shop|product|delete|do|submit'.split('|'),0,{}))	
	
}

function product_update() {
	var product_name = $("#product_name").val();
	var price = $("#price").val();
	var description = $("#description").val();
	if (product_name == "") { //빈값이면
		alert("옵션이름을 입력하세요");
		$("#product_name").focus();
		return;
	}
	if (price == "") { //빈값이면
		alert("가격을 입력하세요");
		$("#price").focus();
		return;
	}	
	if (description == "") { //빈값이면
		alert("옵션 설명을 입력하세요");
		$("#description").focus();
		return;
	}
	//폼 데이터를 받을 주소
	document.form1.action = "${path}/shop/product/update.do";
	//폼 데이터를 서버에 전송
	document.form1.submit();
}
</script>
<h2>옵션 정보 편집</h2>
<form name="form1" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <td>옵션명</td>
      <td><input name="product_name" id="product_name" 
           value="${dto.product_name}"></td>
    </tr>
     <tr>
      <td>가격</td>
      <td><input name="price" id="price" 
           value="${dto.price}"></td>
    </tr>
    <tr>
      <td>옵션설명</td>
      <td><textarea rows="5" cols="60" name="description"
           id="description">${dto.description}</textarea></td>
    </tr>    
     <tr>
      <td>옵션이미지</td>
      <td><img src="${path}/images/${dto.picture_url}" 
           width="300px" height="300px"><br>
           <input type="file" name="file1" id="file1">
           </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
      <!-- 수정,삭제에 필요한 옵션코드값을 hidden 태그로 넘김 -->
      <input type="hidden" name="product_id" 
      value="${dto.product_id }">
      <input type="button" value="수정" onclick="product_update()">
      <input type="button" value="삭제" onclick="product_delete()">
      <input type="button" value="목록" 
      onclick="location.href='${path}/shop/product/list.do'">
    </tr>
  </table>
</form>
</body>
<%@ include file="../include/footer.jsp" %>
</html>