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
    <img class="img-fluid" src="${pageContext.request.contextPath}/images/f2.jpg" alt="Card image cap">

    <!--Card content-->
    <div class="card-body">
        <!--Title-->
        <h4 class="card-title" style="color: red">기아 봉고III 트럭 1톤 4X2 CRDI 초장축</h4>
        <!--Text-->
        <p class="card-text">
        연식/         2018/11
&nbsp          차종/   트럭<br>
        배기량/      3,000cc
&nbsp           변속/   오토<br>
        색상/         흰색
&nbsp               연료/   디젤<br>
        차량번호/   95누8158
&nbsp        주행거리/  2200km          
        
        </p>
        <a href="${path}" class="btn btn-primary">뒤로</a>
    </div>
    
</div>
</div>
</div>
</div>

<%@ include file="../list/f22.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>