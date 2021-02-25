<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/css/home.css">
<link href="https://unpkg.com/nes.css/css/nes.css" rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- ***메인 js 파일은 푸터에 존재함*** -->
</head>
<body>
	<video autoplay muted loop id="karateka">
		<source src="/img/karateka.mp4">
	</video>
	<div class="button" style="cursor: pointer"
		onclick="location.href='/shop/list'">굿즈샵</div>
	<div class="button1" style="cursor: pointer" onclick="back()">이전</div>
	<div class="button2" style="cursor: pointer" onclick="forward()">다음</div>
	<div class="button3" style="cursor: pointer"
		onclick="location.href='/community/community'">커뮤니티</div>
	<div id="start" style="cursor: pointer">start</div>
	<div class="option" style="cursor: pointer" onclick="location.href='/'">option</div>
		
<div class="screenwrapper">
		<div id="gif">
			<img src="/img/press.gif" width="1460px" height="890px">
		</div>
		<div class="container">
			<div class="top">
				<div class="top_Signup">
					<c:if test="${sessionID == null }">
						<div class="top_Signup_Item" onclick="location.href='/user/login'">로그인</div>
						<div class="top_Signup_Item"
							onclick="location.href='/user/signup'">회원가입</div>
					</c:if>
					<c:if test="${sessionID != null }">
						<c:if test="${sessionLevel == 10}">
							<div class="top_Signup_Item"
								onclick="location.href='/admin/main'">관리자페이지</div>
						</c:if>
						<div class="top_Signup_Item">Lv.${sessionLevel }
							${sessionName }님</div>
						<div class="top_Signup_Item"
							onclick="location.href='/user/logout'">로그아웃</div>
						<div class="top_Signup_Item"
							onclick="location.href='/user/mypage?sessionID=${sessionID}'">마이페이지</div>
						<div class="cart"
							onclick="location.href='/cart/cart?sessionid=${sessionID}'">
							<span class="cartspan" data-count=""><img
								src="/img/cart.png" width="100" height="50"></span>
						</div>
					</c:if>
				</div>
			</div>
			<div class="h1" onclick="location.href='/home'">Streamer Goods</div>
			<div class="menu">
				<ul>
					<li><a href="/shop/list">SHOP</a></li>
					<li><a href="/community/community">COMMUNITY</a></li>
					<li><a href="/ask">HELP</a></li>
					<li><a href="/attend">ATTENDANCE</a></li>
				</ul>
			</div>
		</div>
		
		<script type="text/javascript" src="/js/homeheader.js"></script>