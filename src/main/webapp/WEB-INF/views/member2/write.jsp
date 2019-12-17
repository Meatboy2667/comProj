<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원등록</h2>
<form name="form1" method="post" 
action="${path}/member2/insert.do">
<table border="1" width="400px">
  <tr>
    <td>아이디</td>
    <td><input name="userid"></td>
  </tr>
  <tr>
    <td>비밀번호</td>
    <td><input type="password" name="passwd"></td>
  </tr>
  <tr>
    <td>이름</td>
    <td><input name="name"></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input name="email"></td>
  </tr>
  <tr>
    <td colspan="2" align="center">
     <input type="submit" value="확인"></td>
  </tr>
</table>
</form>
</body>
<%@ include file="../include/footer.jsp" %>
</html>