<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="myPage">
			<table class="nes-table is-bordered is-centered">
				<form method="post">
					<tr><td><p>닉네임</p>
						<input name="userNickName" value="${userInfo.userNickName}"></td></tr>
						<tr><td><p>이메일</p>
						<input name="userEmail" value="${userInfo.userEmail }"></td></tr>
						<tr><td><p>전화번호</p>
						<input name="userPhone" value="${userInfo.userPhone }"></td></tr>
						<tr><td><button class="nes-btn is-primary" type="button" onclick="send()">수정</button></td></tr>
						<input type="hidden" name="userUUID" value="${userInfo.userUUID}">

				</form>
				</table>
		</div>
		<script>
			function send(){
				alert("수정되었습니다");
			}
		</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

