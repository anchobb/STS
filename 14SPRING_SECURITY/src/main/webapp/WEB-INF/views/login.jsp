<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MYLOGIN</h1>

<form action="${pageContext.request.contextPath }/login" method="post">
	ID :  <input name="username"><br />
	PW :  <input name="password" type="password"><br />
	
	<div>
		<input type="checkbox" name="remember-me" id="remember-me"/>	
		<lable for="remember-me">로그인 상태를 유지</lable>
	</div>
	
	<input type="submit" />
</form>
<a href="${pageContext.request.contextPath}/join">회원가입</a>
<div>
${msg }
</div>
<div>
${param.error }
</div>

</body>
</html>