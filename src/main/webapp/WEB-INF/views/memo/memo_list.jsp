<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<!-- 필요한 곳에서 적용  -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="${path}/summernote/summernote.css" rel="stylesheet">
<script src="${path}/summernote/summernote.js"></script>

<script type="text/javascript">
$(function(){
	$("#memo").summernote({
		height : 150,
		width : 600
	});
});

function memo_view(idx){
	location.href="${path}/memo/view/"+idx;
	
	//REST(REpresentativ State Transfer)방식, RESTful한 URI방식
	//게시물로 고유한 주소값을 가짐, 게시물하나가 주소1개이다.
	//http://localhost/car/memo/view/1
	//http://localhost/car/memo/view/2
	//따라서 이런방식에서는 스프링에서 @PathVariable 것을 적용해야한다.
	
	//jsp방식에서는 파라미터가 바뀔뿐이지 주소가 바뀌는것은 아님
	//http://localhost/car/memo/view.do?idx=1
	//http://localhost/car/memo/view.do?idx=2
}
</script>


</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>메모장</h2>
<form method="post" action="${path}/memo/insert.do">
  이름 : <input name="writer" size="10"><br>
  메모 : <!-- <input id="memo" name="memo" size="40"> -->
  <textarea rows="3" cols="50" name="memo" id="memo"></textarea>
  
  <input type="submit" value="확인">
</form>

<table border="1" width="500px">
 <tr>
  <th>번호</th>
  <th>이름</th>
  <th>메모</th>
  <th>날짜</th>
 </tr>
 <c:forEach var="row" items="${list}">
 <tr>
  <td>${row.idx}</td>
  <td>${row.writer}</td>
  <td><a href="#" onclick="memo_view('${row.idx}')">
  ${row.memo}</a></td>
  <td><fmt:formatDate value="${row.post_date}" 
      pattern="yyyy-MM-dd HH:mm:ss" />  </td>
 </tr>
 </c:forEach>
</table>
</body>
</html>