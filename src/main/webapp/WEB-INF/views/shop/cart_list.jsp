<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--views/shop/cart_list.jsp  -->
<!DOCTYPE html>
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
$(function(){
	$("#btnList").click(function(){
		//장바구니 목록으로 이동
		location.href="${path}/shop/product/list.do";
	});
	$("#btnDelete").click(function(){
		if(confirm("장바구니를 비우시겠습니까?")){
			location.href="${path}/shop/cart/deleteAll.do";
		}
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>옵션 장바구니</h2>
<c:choose>
  <c:when test="${map.count == 0}">
    장바구니가 비었습니다.
  </c:when>
  <c:otherwise>
    <form name="form1" method="post" 
    action="${path}/shop/cart/update.do">
      <table border="1" width="400px">
        <tr>
          <th>옵션명</th>
          <th>단가</th>
          <th>수량</th>
          <th>금액</th>
          <th>&nbsp;</th>
        </tr>
        <c:forEach var="row" items="${map.list}">
        <tr>
          <td>${row.product_name}</td>
          <td>${row.price}</td>
          <td><input type="number" name="amount" 
          		value="${row.amount}">
              <input type="hidden" name="cart_id" 
                value="${row.cart_id}"></td>
          <td>${row.money}</td>
          <td>
          <c:if test="${sessionScope.userid != null }">
 <a href="${path}/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a>
          </c:if> 
          </td>     
        </tr> 
        </c:forEach>
        <tr>
          <td colspan="5" align="center">
            장바구니 금액 합계 : ${map.sumMoney}<br>
   
            총합계 : ${map.sum}
          </td>
        </tr>
      </table>
      <button id="btnUpdate">수정</button>
      <button type="button" id="btnDelete">장바구니 비우기</button>
    </form>
  </c:otherwise>
</c:choose>
<button type="button" id="btnList">옵션목록</button>

</body>
<%@ include file="../include/footer.jsp" %>
</html>