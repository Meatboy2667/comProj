<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>옵션목록</h2>
<h4 style="color: red">(옵션은 중복이 불가합니다.)</h4>
<table border="1" width="500px">
 <tr>
  <th>옵션코드</th>
  <th>&nbsp;</th>
  <th>옵션</th>
  <th>가격</th>
 </tr>
 <c:forEach var="row" items="${list}">
 <tr>
  <td>${row.product_id}</td>
  <td><img src="${path}/images/${row.picture_url}" 
         width="100px"  height="100px"></td>
  <td><a href="${path}/shop/product/detail/${row.product_id}">
  
  ${row.product_name}</a>
  
  <!-- 관리자에게만 편집 버튼 표시 -->
  <c:if test="${sessionScope.admin_userid != null }">
  <br>
  <a href="${path}/shop/product/edit/${row.product_id}" >[편집]</a>
  </c:if>
  </td>

  <td><fmt:formatNumber value="${row.price}"
         pattern="#,###" /></td>       
 </tr>
 </c:forEach>
</table>
</body>
<%@ include file="../include/footer.jsp" %>
</html>