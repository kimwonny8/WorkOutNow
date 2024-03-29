<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/globalData.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=cssDir%>/style.css">
<style>
* { font-family: 'Spoqa Han Sans Neo', 'sans-serif'; }

.menuDiv {
	opacity: 0.3;
}
</style>
</head>
<body>
	<%
	String m_id = null;
	String m_name = null;
	String loginState = null;
	String m_grade = null;
	String mi_thum_name = null;
	int m_coin = 0;

	if (session.getAttribute("loginState") == null || session.getAttribute("loginState").equals("logout")) {
	%>
	<div class="top">
		<div class="topLogo">
			<button onclick="location.href='<%=rootDir%>/index.jsp'"></button>
		</div>
		<div class="topMenu">
			<button onclick="location.href='<%=wonViewDir%>/signupGrade.jsp'"
				class="Btn topMenuBtn">회원가입</button>
			<button onclick="location.href='<%=wonViewDir%>/login.jsp'"
				class="Btn topMenuBtn">로그인</button>
		</div>
	</div>

	<%
	} else {
	m_id = (String) session.getAttribute("m_id");
	m_name = (String) session.getAttribute("m_name");
	m_grade = (String) session.getAttribute("m_grade");
	%>
	<div class="top">
		<div class="topLogo">
			<button onclick="location.href='<%=rootDir%>/index.jsp'"></button>
		</div>
		<div class="topMenu">
			<button onclick="location.href='./getCartList.won'"
				class="Btn topMenuBtn">
				<img src="<%=imgDir%>/shopping-cart.png" width=20>
			</button>
			<form method="post" action="./logoutMember.won">
				<button class="Btn topMenuBtn">로그아웃</button>
				<p class="topMenuBtn">
					⭐<%=m_grade%>회원⭐
					<%=m_name%>님 환영합니다!
				</p>
			</form>
		</div>
	</div>

	<%}	
	if (m_grade != null && m_grade.equals("관리자")) {
	%>
	<div class="middle">
		<div class="middleMenu">
			<a href="<%=wonViewDir%>/introduce.jsp" class="Btn middleMenuBtn">소개</a>
			<p class="menuDiv">|</p>
			<a href="./getClassList.won" class="Btn middleMenuBtn">수업신청</a>
			<p class="menuDiv">|</p>
			<a href="<%=etcViewDir%>/wait.jsp" class="Btn middleMenuBtn">트레이너공간</a>
			<p class="menuDiv">|</p>
			<a href="<%=wonViewDir%>/admin.jsp" class="Btn middleMenuBtn">관리페이지</a>
			<p class="menuDiv">|</p>
					<a href="<%=etcViewDir%>/wait.jsp" class="Btn middleMenuBtn">고객센터</a>
		</div>
	</div>
	<%
	} else {
	%>
	<div class="middle">
		<div class="middleMenu">
			<a href="<%=wonViewDir%>/introduce.jsp" class="Btn middleMenuBtn">소개</a>
			<p class="menuDiv">|</p>
			<a href="./getClassList.won" class="Btn middleMenuBtn">수업신청</a>
			<p class="menuDiv">|</p>
						<a href="<%=etcViewDir%>/wait.jsp" class="Btn middleMenuBtn">트레이너공간</a>
			<p class="menuDiv">|</p>
			<a href="<%=wonViewDir%>/myPage.jsp" class="Btn middleMenuBtn">마이페이지</a>
			<p class="menuDiv">|</p>
			<a href="<%=etcViewDir%>/wait.jsp" class="Btn middleMenuBtn">고객센터</a>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>