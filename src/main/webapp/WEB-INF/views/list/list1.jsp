<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .Portfolio {
    position: relative;
    margin: 5px;
    border: 2px solid black;
    float: left;
    width: 180px;
    transition-duration: 0.4s;
    border-radius: 5px;
    animation: winanim 0.5s ;
-webkit-backface-visibility:visible;
    backface-visibility:visible;
    box-shadow:0 3px 5px -1px rgba(0,0,0,.2),0 5px 8px 0 rgba(0,0,0,.14),0 1px 14px 0 rgba(0,0,0,.12)
}

.Portfolio:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}

.Portfolio img {
    width: 100%;
    height: auto;
    border-radius: 5px
}

.desc {
    padding: 5px;
    text-align: center;
    font-size: 90%;
    background:white
   ;
    color:hotpink
}

.nav {
    padding:20px;
    margin-left:340px;
    margin-top:-30px;
}
.h6{
color:  black;
}

.nav-link { 
    margin:5px;
    padding: 15px 50px; 
    font-size:16px; 
    color:hotpink; 
    background: white;
    transition-duration: 0.4s;
}
.nav a:hover { 
    background:#333; 
}
.nav .active { 
    background-color: white !important;
    color:#fff;
}

@keyframes winanim {
    0%{opacity:0;transform:scale3d(.3,.3,.3)}
    50%{opacity:1}
    
}
.pco {
color:  black;
}
</style>


</head>
<body>

 <div class="container-fluid" style="margin-top:20px;">
<h1 style="text-align:center;color:black;">매물 리스트 Click</h1><br>
<div class="row">


<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">

  <li class="nav-item">
    <a class="nav-link" id="1-tab" data-toggle="pill" href="#1Cars" role="tab" aria-controls="1Cars" aria-selected="false">경차</a>
  </li>
  <li class="nav-item" >
    <a class="nav-link" id="2-tab" data-toggle="pill" href="#2Cars" role="tab" aria-controls="2Cars" aria-selected="false">중형차</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="3-tab" data-toggle="pill" href="#3Cars" role="tab" aria-controls="3Cars" aria-selected="false">SUV</a>
  </li>
    <li class="nav-item">
    <a class="nav-link" id="4-tab" data-toggle="pill" href="#4Cars" role="tab" aria-controls="4Cars" aria-selected="false">버스/화물</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" id="5-tab" data-toggle="pill" href="#5Cars" role="tab" aria-controls="5Cars" aria-selected="false">스포츠카</a>
  </li>
</ul>
</div><hr noshade style="margin-top:-20px;">
<div class="container">
<div class="tab-content" id="pills-tabContent">

  <div class="tab-pane fade " id="1Cars" role="tabpanel" aria-labelledby="1-tab">
    <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/c1.do"><img class="card-img" src="${pageContext.request.contextPath}/images/c1.jpg" alt=""></a><div class="desc">기아 뉴모닝 1.0 L<br><br>
    <h6 class="pco">경차 /흰색 /가솔린</h6></div></div>
    <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/c2.do"><img class="card-img" src="${pageContext.request.contextPath}/images/c2.jpg" alt=""></a><div class="desc">쉐보레(GM대우) 더 넥스트 스파크 1.0 에코 LTZ<br>
    <h6 class="pco">경차 /검정 /가솔린</h6></div></div>
    <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/c3.do"><img class="card-img" src="${pageContext.request.contextPath}/images/c3.jpg" alt=""></a><div class="desc">스즈키 허슬러 가솔린 660cc 0.6<br>
    <h6 class="pco">경차 /기타 /가솔린</h6></div></div>
  </div>
  <div class="tab-pane fade" id="2Cars" role="tabpanel" aria-labelledby="2-tab">
       <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/d1.do"><img class="card-img" src="${pageContext.request.contextPath}/images/d1.jpg" alt=""></a><div class="desc">기아 K5 2세대 1.7 디젤 MX 디럭스<br>
    <h6 class="pco">중형차 /흰색 /디젤</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/d2.do"><img class="card-img" src="${pageContext.request.contextPath}/images/d2.jpg" alt=""></a><div class="desc">아우디 뉴 A6 디젤 4WD 3.0 TDI 콰트로 다이나믹<br>
    <h6 class="pco">중형차 /검정색 /디젤</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/d3.do"><img class="card-img" src="${pageContext.request.contextPath}/images/d3.jpg" alt=""></a><div class="desc">현대 쏘나타 뉴 라이즈 하이브리드 2.0 스마트<br>
    <h6 class="pco">중형차 /흰색 /가솔린</h6></div></div>
    
  </div>
  <div class="tab-pane fade" id="3Cars" role="tabpanel" aria-labelledby="3-tab">
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/e1.do"><img class="card-img" src="${pageContext.request.contextPath}/images/e1.jpg" alt=""></a><div class="desc">BMW X5 (F15) 디젤 4WD xDrive 30d<br>
    <h6 class="pco">SUV /흰색 /디젤</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/e2.do"><img class="card-img" src="${pageContext.request.contextPath}/images/e2.jpg" alt=""></a><div class="desc">현대 코나 1.6 터보 2WD 스마트<br>
    <h6 class="pco">SUV /검정색 /가솔린</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/e3.do"><img class="card-img" src="${pageContext.request.contextPath}/images/e3.jpg" alt=""></a><div class="desc">지프 그랜드 체로키 디젤 4WD 3.0 디젤 라레도<br>
    <h6 class="pco">SUV /흰색 /디젤</h6></div></div>
    
  </div>

  <div class="tab-pane fade" id="4Cars" role="tabpanel" aria-labelledby="4-tab">
       <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/f1.do"><img class="card-img" src="${pageContext.request.contextPath}/images/f1.jpg" alt=""></a><div class="desc">현대 e카운티 롱바디 DLX 15인승<br>
    <h6 class="pco">버스화물 /기타 /디젤</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/f2.do"><img class="card-img" src="${pageContext.request.contextPath}/images/f2.jpg" alt=""></a><div class="desc">기아 봉고III 트럭 1톤 4X2 CRDI 초장축<br>
    <h6 class="pco">버스화물 /청색 /디젤</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/f3.do"><img class="card-img" src="${pageContext.request.contextPath}/images/f3.jpg" alt=""></a><div class="desc">기아 봉고III 트럭 기타 냉동탑차<br>
    <h6 class="pco">버스화물 /흰색 /디젤</h6></div></div>
  </div>

  <div class="tab-pane fade" id="5Cars" role="tabpanel" aria-labelledby="5-tab">
      <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/g1.do"><img class="card-img" src="${pageContext.request.contextPath}/images/g1.jpg"></a><div class="desc">포드 머스탱 가솔린 GT 컨버터블<br>
    <h6 class="pco">스포츠카 /검정색 /가솔린</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/g2.do"><img class="card-img" src="${pageContext.request.contextPath}/images/g2.jpg" alt=""></a><div class="desc">쉐보레(GM대우) 카마로 가솔린 3.6<br>
    <h6 class="pco">스포츠카 /노랑색 /가솔린</h6></div></div>
        <div class="Portfolio"><a href="${pageContext.request.contextPath}/list/g3.do"><img class="card-img" src="${pageContext.request.contextPath}/images/g3.jpg" alt=""></a><div class="desc">재규어 F-TYPE 가솔린 3000cc 3.0 S 쿠페<br>
    <h6 class="pco">스포츠카 /빨강색 /가솔린</h6></div></div>
  </div>
     </div>
        </div>
</div>




</body>
</html>