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
    <img class="img-fluid" src="${pageContext.request.contextPath}/images/c1.jpg" alt="Card image cap">

    <!--Card content-->
    <div class="card-body">
        <!--Title-->
        <h4 class="card-title" style="color: red">기아 뉴모닝 1.0 L</h4>
        <!--Text-->
        <p class="card-text">
        연식/         2011/12
&nbsp          차종/   경차<br>
        배기량/      1,000 cc
&nbsp           변속/   오토<br>
        색상/         흰색
&nbsp               연료/   가솔린<br>
        차량번호/   38무9555
&nbsp        주행거리/  30,458Km          
        
        </p>
        <a href="${path}" class="btn btn-primary">뒤로</a>
    </div>
    
</div>
</div>
</div>
</div>

<%@ include file="../list/c12.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>