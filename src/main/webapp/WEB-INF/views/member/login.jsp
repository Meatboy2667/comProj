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
<script>
$(function(){
	$("#btnLogin").click(function(){
		var userid=$("#userid").val(); //태그의 value 속성값
		var passwd=$("#passwd").val();
		if(userid==""){
			alert("아이디를 입력하세요.");
			$("#userid").focus(); //입력 포커스 이동
			return; //함수 종료
		}
		if(passwd==""){
			alert("비밀번호를 입력하세요.");
			$("#passwd").focus();
			return;
		}
		//폼 데이터를 서버로 제출
		document.form1.action="${path}/member/login_check.do";
		document.form1.submit();
	});
	
	$("#write").click(function(){
		location.href="${path}/member2/write.do";
	});
});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>로그인</h2>
<form name="form1" method="post">
<div class="container" >
      <div class="row">
        <div class="page-header">
          <h4>환영합니다.!</h4>
          <c:if test="${param.message == 'nologin' }">
				<div style="color:red;">
					로그인 하신 후 사용하세요.
				</div>				
			</c:if>
			<c:if test="${message == 'error' }">
				<div style="color:red; ">
					아이디 또는 비밀번호가 일치하지 않습니다.
				</div>
			</c:if>
			<c:if test="${message == 'logout' }">
				<div  style="color:blue;" >
					로그아웃 처리되었습니다.
				</div>
			</c:if >
        </div>
        <div class="col-md-3">
          <div class="login-box well">

            <legend>로그인</legend>
            <div class="form-group">
                <label for="username-email">아이디 입력</label>
                <input name="userid" value='' id="userid" placeholder=" Username" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input name="passwd" id="passwd" value='' placeholder="Password" type="password" class="form-control" />
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-default btn-login-submit btn-block m-t-md" id="btnLogin" value="Login" />
            </div>
            <span class='text-center'><a href="/bbs/index.php?mid=index&act=dispMemberFindAccount" class="text-sm">비밀번호 찾기</a></span>
            <hr />
            <div class="form-group">
                <a id="write" class="btn btn-default btn-block m-t-md">회원가입</a>
            </div>
          </div>
        </div>
      </div>
      
    </div>


	
			
</form>
</body>
<%@ include file="../include/footer.jsp" %>
</html>
