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
    <img class="img-fluid" src="${pageContext.request.contextPath}/images/c2.jpg" alt="Card image cap">

    <!--Card content-->
    <div class="card-body">
        <!--Title-->
        <h4 class="card-title" style="color: red">쉐보레(GM대우) 더 넥스트 스파크 1.0 에코 LTZ</h4>
        <!--Text-->
        <p class="card-text">
        연식/         2018/3
&nbsp          차종/   경차<br>
        배기량/      1,000 cc
&nbsp           변속/   오토<br>
        색상/         검정색
&nbsp               연료/   가솔린<br>
        차량번호/   31도8589
&nbsp        주행거리/  3,479Km         
        
        </p>
        <a href="${path}" class="btn btn-primary">뒤로</a>
    </div>
    
</div>
</div>
</div>
</div>

<%@ include file="../list/c22.jsp" %>
</body>
<%@ include file="../include/footer.jsp" %>
</html>