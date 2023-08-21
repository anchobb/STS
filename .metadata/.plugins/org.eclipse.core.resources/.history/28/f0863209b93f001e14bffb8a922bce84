<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USER PAGE</title>
<style>
		<%@include file="/resources/static/css/common.css" %>
		<%@include file="/resources/static/css/header.css" %>
		<%@include file="/resources/static/css/user_Page.css" %>
		<%@include file="/resources/static/css/footer.css" %>		
</style>
</head>
<body>

<div class="wrapper">
<header>
   <div class="log-header">
       <a href=<c:url value="/indexlog.do" />><img class="logo" src="resources/static/img/로고.png" alt=""></a>
       <ul>
          <li><a href=""><img  src="resources/static/img/english.png" alt="">ENGLISH</a></li>
       </ul>
    </div>
    <div class="logheader_line"></div>
</header>
<section class="user">
	<h1>내 정보를 확인 해보세요!</h1>
	<ul>
	<c:if test="${empty updatedDto}">
		<li><span class="title">ID</span><hr/><span class="info">${userDto.id }</span> </li>
		<br />
		<li><span class="title">NAME</span><hr/> <span class="info">${userDto.name}</span></li>
		<br />
		<li><span class="title">PW</span><hr/><span class="info" >****</span></li>
		<br />
		<li><span class="title">ADDR</span><hr/><span class="info">${userDto.addr}</span></li>
		<br />
		<li><span class="title">PHONE</span><hr/><span class="info">${userDto.phone}</span></li>
		<button id="back_btn" onclick= "location.href='${pageContext.request.contextPath}/indexlog.do'">이전</button>
		<button id="update_btn" onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button>
	</c:if>

	<c:if test="${not empty updatedDto}">
		<li><span class="title">ID</span><hr/><span class="info">${updatedDto.id }</span> </li>
		<br />
		<li><span class="title">NAME</span><hr/><span class="info">${updatedDto.name}</span></li>
		<br />
		<li><span class="title">PW</span><hr/><span class="info" >****</span></li>
		<br />
		<li><span class="title">ADDR</span><hr/><span class="info">${updatedDto.addr}</span></li>
		<br />
		<li><span class="title">PHONE</span><hr/><span class="info">${updatedDto.phone}</span></li>
		<button id="back_btn" onclick= "location.href='${pageContext.request.contextPath}/indexlog.do'">이전</button>
		<button id="update_btn" onclick = "location.href='${pageContext.request.contextPath}/member/update.do'">정보수정</button>
		<br />
	</c:if>
	</ul>
</section>

<footer>
    <div class="footer_line"></div>
    <div>
        <ul class="footer_menu">
           <li><a href="">이용약관</a></li>
           <li><a href="">고객센터</a></li>
           <li><a href="">제휴/프로모션</a></li>
           <li><a href=""> 개인정보처리방침</a></li>
        </ul>
    </div>
    <p></p>
    <div class="Site_info">
        <img id="footer_logo" src="resources/static/img/로고.png" alt="">
        <span class="Sitename">(주)WATERMELON MUSIC</span>
        <span>대구광역시 중구 중앙대로 366 반월센트럴타워 10층</span>
        <span>대표이사 : 윤치연, 김예솔, 이헌지, 최정기</span>
        <span>사업자등록번호 : 024-04-02023</span>
        <br>
        <span>문의전화 : 1544-1111 (평일 09:00-18:00)</span>
        <span>WATERMELON MUSIC으로 음악과 함께하는 즐거운 하루 보내세요!</span>
     </div>
</footer>
</div>

</body>
</html>