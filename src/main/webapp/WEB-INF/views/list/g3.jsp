<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.img-fluid {
height: 250px;
width: 280px;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-sm-4">
<div class="card" >

    <!--Card image-->
    <img class="img-fluid" src="${pageContext.request.contextPath}/images/g3.jpg" alt="Card image cap">

    <!--Card content-->
    <div class="card-body">
        <!--Title-->
        <h4 class="card-title" style="color: red">재규어 F-TYPE 가솔린 3000cc 3.0 S 쿠페</h4>
        <!--Text-->
        <p class="card-text">
        연식/         2017/7
&nbsp          차종/   스포츠카<br>
        배기량/      3,000cc
&nbsp           변속/   오토<br>
        색상/         빨강색
&nbsp               연료/   가솔린<br>
        차량번호/   17러0318
&nbsp        주행거리/  7900km          
        
        </p>
        <a href="${path}" class="btn btn-primary">뒤로</a>
    </div>
    
</div>
</div>
</div>
</div>

<%@ include file="../list/g33.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>