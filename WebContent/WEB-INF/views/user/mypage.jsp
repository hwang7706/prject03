<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
			var modify = "${msg}";
			if(modify == "modify-complete"){
				alert(modify);
			}
		</script>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/userSystem.css">
		<div class="myPage">
			<table class="nes-table is-bordered is-centered">
			<tr class="myPage_UserName">
				<td>${userVO.userName } 님 의 페이지</td>
			</tr>
						<tr><td><p>아이디</p>
						${userVO.userID }</td></tr>
						<tr><td><p>닉네임</p>
						${userVO.userNickName }</td></tr>
						<tr><td><p>레벨 ${userVO.userLevel }</p>
						 exp<progress class="nes-progress is-primary" value="70" max="100"></progress></td></tr>
						<tr><td><p>이메일</p>
						${userVO.userEmail }</td></tr>
						<tr><td><p>전화번호</p>
						${userVO.userPhone }</td></tr>
						<tr><td><p>회원가입날짜</p>
						${userVO.userSignUpDate }</td></tr>
						<tr><td><button type="button" class="nes-btn is-primary" onclick="location.href='/user/userModify?sessionID=${sessionID}'">회원수정하기</button></td></tr>
			</table>
		</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
		

