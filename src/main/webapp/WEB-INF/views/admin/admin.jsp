<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>



<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<script type="text/javascript">
$(document).ready(function() {
  $('.prev').click(function() {
    $('.list').stop().animate({
      'margin-left': '-800px'
    }, function() {
      $('.list li:first-child').appendTo('.list');
      $('.list').css({
        'margin-left': '-400px'
      });
    });
  });
  $('.next').click(function() {
    $('.list').stop().animate({
      'margin-left': '0px'
    }, function() {
      $('.list li:last-child').prependTo('.list');
      $('.list').css({
        'margin-left': '-400px'
      });
    });
  });
  $('.carousel').mouseenter(function(){
      clearInterval(auto);  
 });
 
 /* 마우스 내렸을때 캐러셀 자동 다시실행 */
 $('.carousel').mouseleave(function(){
      auto = setInterval(function(){
       		$('.list').stop().animate({'margin-left':'0px'},function(){
         $('.list>li').eq(2).prependTo('.list');
         $('.list').css({'margin-left':'-400px'});
      });
  },1950);
 });
});

</script>
<style>
* {
  margin: 0px;
  padding: 0px;
}

ul {
  list-style: none;
}

a {
  text-decoration: none;
}

img {
  border: none;
  vertical-align: top;
  height: 100%;
  width: 100%;
}

.c_wrap {
  width: 100%;
  margin: 0 auto;
  position: relative;
  border: 2px solid #000;
  background-color: black;

}

.carousel {
  width: 400px;
  margin: 0 auto;
  border: 2px solid ;
  overflow: hidden;
    height: 250px;
}

.carousel .list {
  width: 1600px;
  margin-left: -400px;
}

.carousel .list:after {
  content: "";
  display: block;
  clear: both;
}

.carousel .list li {
  float: left;

  width: 400px;
  color: white;
  font-size: 50px;
}

.carousel .list li.a1 {

}

.carousel .list li.a2 {
  background-color: blue;
}

.carousel .list li.a3 {
  background-color: green;
}

.carousel .list li.a4 {
  background-color: gray;
}

.prev {
  position: absolute;
  left: 0px;
  top: 50%;
  width: 25px;
  height: 50px;
  background-color: #000;
  color: #fff;
  margin-top: -25px;
}

.next {
  position: absolute;
  right: 0px;
  top: 50%;
  width: 25px;
  height: 50px;
  background-color: #000;
  color: #fff;
  margin-top: -25px;
}
</style>
<meta charset="UTF-8">s
	<title>Home</title>
<%@ include file="../include/header.jsp" %>	

</head>
<body>
<%@ include file="../include/admin_menu.jsp" %>
<!-- 세션변수가 존재하면 -->
<div><c:if test="${sessionScope.admin_userid != null }">
  <h2>
    ${sessionScope.admin_name}
    (${sessionScope.admin_userid})님의 방문을 환영합니다.
  </h2>
</c:if>
<form action="${path}/list/list1" 
 method="post" target="iframeList1" >

</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div class="c_wrap">
  <div class="carousel">
    <ul class="list">
      <li class="a1"  ><img src ="${pageContext.request.contextPath}/images/s1.jpg"></li>
      <li class="a2"><img src ="${pageContext.request.contextPath}/images/s2.jpg"></li>
      <li class="a3"><img src ="${pageContext.request.contextPath}/images/s3.jpg"></li>
      <li class="a4"><img src ="${pageContext.request.contextPath}/images/s4.jpg"></li>
    </ul>
  </div>
  <p class="prev"></p>
  <p class="next"></p>
</div>
<%@ include file="../list/list1.jsp" %>


</body>
<%@ include file="../include/footer.jsp" %>
</html>
