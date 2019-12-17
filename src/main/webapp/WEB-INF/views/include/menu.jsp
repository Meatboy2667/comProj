<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
html, body {
	overflow-x: hidden; /* Prevent scroll on narrow devices */
}

body {
	padding-top: 100px;
}

footer {
	padding: 30px 0;
}

/*
 * Custom styles
 */
.navbar-brand {
	font-size: 24px;
}

.navbar-container {
	padding: 20px 0 20px 0;
}

.navbar.navbar-fixed-top.fixed-theme {
	background-color: #222;
	border-color: #080808;
	box-shadow: 0 0 5px rgba(0, 0, 0, .8);
}

.navbar-brand.fixed-theme {
	font-size: 18px;
}

.navbar-container.fixed-theme {
	padding: 0;
}

.navbar-brand.fixed-theme, .navbar-container.fixed-theme, .navbar.navbar-fixed-top.fixed-theme,
	.navbar-brand, .navbar-container {
	transition: 0.8s;
	-webkit-transition: 0.8s;
}
</style>
<script>
$(document).ready(function(){

	/**
	 * This object controls the nav bar. Implement the add and remove
	 * action over the elements of the nav bar that we want to change.
	 *
	 * @type {{flagAdd: boolean, elements: string[], add: Function, remove: Function}}
	 */
	var myNavBar = {

	    flagAdd: true,

	    elements: [],

	    init: function (elements) {
	        this.elements = elements;
	    },

	    add : function() {
	        if(this.flagAdd) {
	            for(var i=0; i < this.elements.length; i++) {
	                document.getElementById(this.elements[i]).className += " fixed-theme";
	            }
	            this.flagAdd = false;
	        }
	    },

	    remove: function() {
	        for(var i=0; i < this.elements.length; i++) {
	            document.getElementById(this.elements[i]).className =
	                    document.getElementById(this.elements[i]).className.replace( /(?:^|\s)fixed-theme(?!\S)/g , '' );
	        }
	        this.flagAdd = true;
	    }

	};

	/**
	 * Init the object. Pass the object the array of elements
	 * that we want to change when the scroll goes down
	 */
	myNavBar.init(  [
	    "header",
	    "header-container",
	    "brand"
	]);

	/**
	 * Function that manage the direction
	 * of the scroll
	 */
	function offSetManager(){

	    var yOffset = 0;
	    var currYOffSet = window.pageYOffset;

	    if(yOffset < currYOffSet) {
	        myNavBar.add();
	    }
	    else if(currYOffSet == yOffset){
	        myNavBar.remove();
	    }

	}

	/**
	 * bind to the document scroll detection
	 */
	window.onscroll = function(e) {
	    offSetManager();
	}

	/**
	 * We have to do a first detectation of offset because the page
	 * could be load with scroll down set.
	 */
	offSetManager();
	});

</script>


<nav id="header" class="navbar navbar-fixed-top">
	<div id="header-container" class="container navbar-container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a id="brand" class="navbar-brand" href="${path}"> <img
				style="height: 185%; width: 68%"
				src="${pageContext.request.contextPath}/images/MR.jpg">
			</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="${path}">Home</a></li>
				<li><a href="${path}/board2/list.do">공지사항</a></li>
				<li><a href="${path}/board/list.do">Q&A게시판</a></li>
				<li><a href="${path}/shop/product/list.do">옵션목록</a></li>
				<c:if test="${sessionScope.admin_userid != null }">
					<li><a href="${path}/shop/product/write.do">옵션등록</a></li>
				</c:if>
				<li class="nav-item"><c:if
						test="${sessionScope.userid != null }">
						<li><a href="${path}/shop/cart/list.do">장바구니</a></li>
					</c:if>
			</ul>
			<div style="text-align: right;">
				<c:choose>
					<c:when test="${sessionScope.userid == null }">
						<!-- 로그인하지 않은 상태 -->
						<a href="${path}/member/login.do"><button type="button"
								class="btn btn-primary btn-md">
								로그인<i class="fa fa-sign-in"></i>
							</button></a>
						<a href="${path}/admin/login.do"><button type="button"
								class="btn btn-default btn-md">관리자로그인</button></a>
					</c:when>
					<c:otherwise>
						<!-- 로그인한 상태 -->
						<h4 style="color: purple;">${sessionScope.name}님이 로그인중입니다.</h4>
						<a href="${path}/member/logout.do"><button type="button"
								class="btn btn-danger btn-lg">로그아웃</button></a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- /.nav-collapse -->
	</div>
	<!-- /.container -->
</nav>
<!-- /.navbar -->









