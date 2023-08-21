<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>USER</h1>

principal : <sec:authentication property="principal"/> <hr />
userDto :  <sec:authentication property="principal.user"/> <hr />
username :  <sec:authentication property="principal.user.username"/> <hr />
role :  <sec:authentication property="principal.user.role"/> <hr />



<form action="${pageContext.request.contextPath }/logout" method="post">
	<button>로그아웃</button>
</form>

</body>
</html>