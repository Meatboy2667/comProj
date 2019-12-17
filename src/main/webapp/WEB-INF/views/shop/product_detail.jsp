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
<h2>옵션정보</h2>
<table>
 <tr>
  <td><img src="${path}/images/${dto.picture_url}" 
  width="300px" height="300px"></td>
  <td align="center">
    <table>
      <tr>
        <td>옵션명</td>
        <td>${dto.product_name}</td>
      </tr>
      <tr>
        <td>가격</td>
        <td>${dto.price}</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>${dto.description}</td>
      </tr>
      <tr>
        <td colspan="2">
          <form name="form1" method="post" 
            action="${path}/shop/cart/insert.do">
            <input type="hidden" name="product_id" 
            value="${dto.product_id}">
            <select name="amount">
             <c:forEach begin="1" end="10" var="i">
               <option value="${i}">${i}</option>
             </c:forEach>
            </select>
            <input type="submit" value="장바구니에 담기">  
          </form>
        </td>
      </tr>
    </table>
  </td>
 </tr>
</table>
</body>
<%@ include file="../include/footer.jsp" %>
</html>