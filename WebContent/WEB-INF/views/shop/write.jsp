<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">	
<body>
<form name="write" method="post" enctype="multipart/form-data">
<div class="center">
<table class="nes-table is-bordered is-dark">
	<tr><td>상품제목</td><td><input type="text" class="nes-input is-dark" name="itemName" id="itemName"></td></tr>
	<tr><td>셀러</td>		
		<td><select name="itemTitleCategory">
			<c:forEach var="seller" items="${seller}">
				<option value="${seller.sellerDomain}">${seller.sellerName}</option>
			</c:forEach>
		</select>
	</td>
	<tr><td>미드카테</td>
		<!-- <select name="itemMidCategory">
			<option value="의류">의류</option>
			<option value="악세서리">악세서리</option>
		</select> -->
		<td><input type="text" class="nes-input is-dark" name="itemMidCategory">
	</td></tr>
	<tr><td>바텀카테</td>
		<!-- <select name="itemBottomCategory">
			<option value="모자">모자</option>
			<option value="후드">후드</option>
			<option value="목걸이">목걸이</option>
		</select> -->
		<td><input type="text" class="nes-input is-dark" name="itemBottomCategory">
	</td></tr>
	<tr><td>가격</td><td><input type="text" class="nes-input is-dark" name="itemPrice" id="itemPrice"></td></tr>
	<tr><td>첨부파일</td><td><input type="file" name="img_m"></td></tr>
	<tr><td colspan=2><button type="button" class="nes-btn" onclick="send()">등록</button></td></tr>
	</form>
	</table>
</div>
<script>
	function send(){
		document.write.submit();
	}
</script>
</body>
</html>