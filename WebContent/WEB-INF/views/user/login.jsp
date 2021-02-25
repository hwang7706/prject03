<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
			<form id="loginForm" class="loginBorder" method="post">
			<table class="nes-table is-centered" border="0">
				<tr><td class="loginInput"><input type="text" class="nes-input" placeholder="ID" name="userID"></td></tr>
				<tr><td class="loginInput"><input type="text" class="nes-input" placeholder="PASSWORD" name="userPassword"></td></tr>
				<tr><td class="loginButton"><button type="button" class="nes-btn is-primary" onclick='document.getElementById("loginForm").submit()'>로그인</button></td></tr>
				<tr><td class="loginoption">
					<button type="button" class="nes-btn is-primary" onclick="location.href='/user/idsearch'">아이디 찾기</button>
					<button type="button" class="nes-btn is-primary" onclick="location.href='/user/passwordsearch'">비밀번호 찾기</button>
					<button type="button" class="nes-btn is-primary" onclick="location.href='/user/signup'">회원가입</button>
				</td></tr>
			</table>
			</form>
		<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>