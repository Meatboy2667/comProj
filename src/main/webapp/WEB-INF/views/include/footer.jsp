<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<style type="text/css">


.copyrights{
margin-top:25px;
}

footer.container-fluid.text-center.foot {
    background: #383838;
}

.dark-line{
border-top: 1px solid #525252;
}

.white-txt{
color: #FFF;
}


a.link {
    color: #008acc;
    border: 1px #008acc solid;
    padding: 5px;
    text-decoration: none;
}

a.link:hover {
background: #008acc;
    color: #383838;
}





.social:hover {
     -webkit-transform: scale(1.1);
     -moz-transform: scale(1.1);
     -o-transform: scale(1.1);
 }
 .social {
     -webkit-transform: scale(0.8);
     /* Browser Variations: */
     
     -moz-transform: scale(0.8);
     -o-transform: scale(0.8);
     -webkit-transition-duration: 0.5s;
     -moz-transition-duration: 0.5s;
     -o-transition-duration: 0.5s;
 }

/*
    Multicoloured Hover Variations
*/
 
 #social-fb:hover {
     color: #3B5998;
 }
 #social-tw:hover {
     color: #4099FF;
 }
 #social-gp:hover {
     color: #d34836;
 }
 #social-em:hover {
     color: #f39c12;
 }

</style>




</head>
<body>
<footer class="container-fluid text-center foot">

        <div class="copyrights">
            <p class="white-txt">미래카옥션 © 2018</p>
       
     <div class="text-center center-block">
        
                <a href="https://www.facebook.com/bootsnipp"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
	            <a href="https://twitter.com/bootsnipp"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
	            <a href="https://plus.google.com/+Bootsnipp-page"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
	            <a href="mailto:bootsnipp@gmail.com"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
</div>
    <hr>
</div>
    
            <hr class="dark-line">
            <a class="link" href="#">이용자약관</a>&nbsp
            <a class="link" href="#">개인정보취급방침</a>&nbsp
            <a class="link" href="#">광고 및 제휴문의</a>
            <br><br>
            <p class="white-txt small">
             서울 강동구 천호대로 10  / 사업자번호 : 092-61-00110 Copyrightⓒ2018/  By 미래카옥션. ALL RIGHTS RESERVED.
            </p>
        </div>
</footer>
</body>
</html>