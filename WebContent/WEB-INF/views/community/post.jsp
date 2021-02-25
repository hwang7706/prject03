<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/community.css">	
<body>
<h1>커뮤니티 글쓰기페이지</h1>
<form name="posting" method="post" enctype="multipart/form-data">
<div class="center">
<table class="nes-table is-bordered is-dark">
	<tr><td>작성자</td><td><input type="text" class="nes-input is-dark" name="postUsername" id="postUsername" value="${sessionID}"></td></tr>
	<tr><td>제목</td><td><input type="text" class="nes-input is-dark" name="postTitle" id="postTitle"></td></tr>
	<tr><td>이미지</td><td><input type="file" name="file"></td></tr>
	<tr><td>내용</td><td><input type="text" class="nes-input is-dark" name="postContent"></td></tr>
	<tr><td colspan="2"><button type="button" class="nes-btn" onclick="send()">등록</button></td></tr>
</table>
</div>	
	</form>
</body>
<script>
	function send(){
		document.posting.submit();
	}
</script>
</html>