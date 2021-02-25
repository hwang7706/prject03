<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">

		<div class="signupContainer">
			<table class="nes-table is-bordered is-centered">
			<form name="form1" id="form1" class="signupBorder" method="post">
				<tr class="signupItem">
					<td class="signupText">아이디</td>
					<td class="signupInput">
						<div><input placeholder="ID" id="userID" name="userID" required></div>
						<div id="checkid"></div>
						<input type="hidden" name="idck" id="idck" value="0">
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">이름</td>
					<td class="signupInput">
						<div><input placeholder="NAME" name="userName"></div>
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">비밀번호</td>
					<td class="signupInput">
						<div><input placeholder="PASSWORD" name="userPassword"></div>
						<div class="signupINFO">안전한 비밀번호를 입력해주세요</div>
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">닉네임</td>
					<td class="signupInput">
						<div><input placeholder="Nick_Name" name="userNickName"></div>
						<div class="signupINFO">당당히 말할수있는 닉네임을 사용해주세요</div>
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">스팀 아이디</td>
					<td class="signupInput">
						<div><input placeholder="Steam_ID" name="userSteamID"></div>
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">이메일주소</td>
					<td class="signupInput">
						<div><input placeholder="Email_Address" name="userEmail"></div>
					</td>
				</tr>
				<tr class="signupItem">
					<td class="signupText">전화번호</td>
					<td class="signupInput">
						<div><input placeholder="Phone_Number" name="userPhone"></div>
						<div class="signupINFO">'-' 는 빼서 입력해주세요</div>
					</td>
				</tr>
				<tr class="signupButton">
					<td colspan="2"><button type="button" class="nes-btn is-primary" onclick="send()">회원가입</button></td>
				</tr>
			</form>
			</table>
		</div>
	<script>
		function send(){
			document.form1.submit();
		}
	</script>
	<script>
			var welcome = "${msg}";
			if(welcome != ''){
				alert(welcome);
			}
	</script>	
	<script type="text/javascript" src="/js/userSystem.js"></script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
