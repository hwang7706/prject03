<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/attend.css">
<div class="attend">
	<table class="nes-table is-bordered is-centered">
		<tr class="attendTitle">
			<td class="title" colspan="3"><p>출석체크</p></td>
		</tr>
		<c:if test="${sessionNickName == null}">
			<tr>
				<td class="attendUser" colspan="3">
					<div>게스트</div>
				</td>
			</tr>
		</c:if>
		<tr class="attendInputForm">
			<td colspan="2" class="attendInput"><input id="content"
				name="content" placeholder="출석체크를 하고 경험치를 올리세요"></td>
			<td class="attendButton">
				<button type="button" class="nes-btn is-error"
					onclick="send()">출석체크</button>
			</td>
		</tr>
		<tr>
			<td colspan="3">Lv.10 <b>간디가어딜간디</b> 2021-01-12
			<p>ㄹㅇㅋㅋ 만쳐</p></td>
		</tr>
		<tr>
			<td colspan="3">Lv.1 <b>slekslsl</b> 2021-01-12
			<p>우아아아아아앙</p></td>
		</tr>
		<tr>
			<td colspan="3">Lv.1 <b>tjtjtj</b> 2021-01-12
			<p>출석체크!!!</p></td>
		</tr>
	</table>
</div>
<script src="/js/attendSystem.js"></script>
<script>
	let welcome = "${msg}";
	if (welcome != '') {
		alert(welcome);
	}
</script>
<script>
	function send(){
		alert("하루 한번만 가능합니다")
	}
</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
