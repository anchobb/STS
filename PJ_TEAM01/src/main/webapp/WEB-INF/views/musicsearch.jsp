<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		<%@include file="/resources/static/css/common.css" %>
		<%@include file="/resources/static/css/header.css" %>
		<%@include file="/resources/static/css/Main_Search_Page.css" %>
		<%@include file="/resources/static/css/footer.css" %>		
	</style>
</head>
<body>

<%
    // 검색어를 받아옵니다.
    String searchText = request.getParameter("searchText");
    // searchText가 null이라면 빈 문자열로 초기화합니다.
    if (searchText == null) {
        searchText = "";
    }
%>
	<div class="wrapper">
        <!-- 메인 -->
        <header>
            <div class="top-header">
                <a href=<c:url value="/index.do" />><img class="logo" src="${pageContext.request.contextPath}/resources/static/img/로고.png" alt=""></a>
                <form action="<c:url value='/music/search.do' />" method="get">
                <div class="search_box">
                    <div class="search_btn" id="searchButton">SEARCH</div>
                    <input id="searchInput" type="text" name="searchText" placeholder="듣고 싶은 노래를 검색하세요!" >
                    <img id="searchIcon" src="${pageContext.request.contextPath}/resources/static/img/search.png" alt="" onclick="window.location.href='<c:url value="/music/search.do" />'" >
                </div>
                </form>
                <ul>
                    <li><a href="" style="color:rgb(92, 115, 6); font-family: 'NanumSquareAceb';"><img
                                src="${pageContext.request.contextPath}/resources/static/img/add.png" alt=""> 멤버십가입</a></li>
                    <li><a href=""><img src="${pageContext.request.contextPath}/resources/static/img/english.png" alt="">ENGLISH</a></li>
                </ul>
            </div>
        </header>
        <nav>
            <div class="mobilemenu">
                <span href="" class="material-symbols-outlined">menu
                    <ul class="wa">
                        <li><a href="">수박차트</a></li>
                        <li><a href="">수박DJ</a></li>
                        <li><a href="">수박TV</a></li>
                        <li><a href="">수박매거진</a></li>
                        <li><a href="./QnA_Page.html">공지사항</a></li>
                        <li><a href="">마이페이지</a></li>
                    </ul>
                </span>
            </div>
            <div class="navi">
                <div class="Menu_left">
                    <ul class="one--depth">
                        <li>
                            <a href="">수박차트</a>
                            <ul class="two--depth">
                                <li><a href="./TOP100.html">국내TOP100</a></li>
                                <li><a href="">해외TOP100</a></li>
                                <li><a href="">최신음악</a></li>
                                <li><a href="">장르음악</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박DJ</a>
                            <ul class="two--depth">
                                <li><a href="">#투데이</a></li>
                                <li><a href="">테마장르</a></li>
                                <li><a href="">인기선곡</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박TV</a>
                            <ul class="two--depth">
                                <li><a href="">뮤직비디오</a></li>
                                <li><a href="">수박방송</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">수박매거진</a>
                            <ul class="two--depth">
                                <li><a href="">오늘의매거진</a></li>
                                <li><a href="">완결매거진</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="Menu_right">
                    <ul class="one--depth">
                        <li>
                            <a href="">공지사항</a>
                            <ul class="two--depth">
                                <li><a href="">공지사항</a></li>
                                <li><a href="./QnA_Page.html">QnA</a></li>
                                <li><a href="">자주하는질문</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">마이페이지</a>
                            <ul class="two--depth">
                                <li><a href="">정보수정</a></li>
                                <li><a href="">마이리스트</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
        <div class="header_line"></div>
        <main>
            <aside class="searchresult"> 검색 결과
                <div class="table-wrapper">
                    <table id="searchTable">
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Artist</th>
                            <th>URL</th>
                        </tr>
                    </table>
                </div>
            </aside>
        </main>
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
                <img id="footer_logo" src="${pageContext.request.contextPath}/resources/static/img/로고.png" alt="">
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
    
    <!-- axios cdn -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.4.0/axios.min.js"
            integrity="sha512-uMtXmF28A2Ab/JJO2t/vYhlaa/3ahUOgj1Zf27M5rOo8/+fcTUVH0/E0ll68njmjrLqOBjXM3V9NiPFL5ywWPQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    <script>
        // Main_Search_Page.jsp의 <script> 태그 안에 추가해주세요.
        // 검색 아이콘 클릭 시 검색 결과 페이지로 이동
        document.getElementById('searchIcon').addEventListener('click', function () {
            searchMusic();
        });

        // input 요소에서 Enter 키를 누르면 검색 결과 페이지로 이동
        document.getElementById('searchInput').addEventListener('keydown', function (event) {
            if (event.keyCode === 13) {
                searchMusic();
            }
        });

        function searchMusic() {
            const searchText = document.getElementById('searchInput').value;
            const projectPath = '${pageContext.request.contextPath}';
            const ServerPort = '${pageContext.request.serverPort}';

            axios.get("http://localhost:" + ServerPort + projectPath + "/music/search.do", {
                params: { searchText: searchText }
            })
            .then(response => {
                const list = response.data;
                const table_el = document.getElementById('searchTable');

                // 기존 테이블의 내용 삭제
                //table_el.innerHTML = '';
                table_el.innerHTML = '<tr><th>No</th><th>Name</th><th>Artist</th><th>URL</th></tr>';

                list.forEach((dto, index) => {
                    // 검색 결과를 테이블에 추가
                    const row = document.createElement('tr');
                    const noCell = document.createElement('td');
                    noCell.innerText = index + 1; // 검색 결과 순서에 따른 번호 출력
                    const nameCell = document.createElement('td');
                    nameCell.innerText = dto.name;
                    const artistCell = document.createElement('td');
                    artistCell.innerText = dto.artist;
                    const urlCell = document.createElement('td');
                    const urlLink = document.createElement('a');
                    urlLink.href = dto.url;
                    urlLink.innerText = dto.url;
                    urlLink.target = '_blank';
                    urlCell.appendChild(urlLink);

                    row.appendChild(noCell);
                    row.appendChild(nameCell);
                    row.appendChild(artistCell);
                    row.appendChild(urlCell);

                    table_el.appendChild(row);
                });
            })
            .catch(error => {
                alert("fail..!");
            });
        }
    </script>
    
    
</body>
</html>