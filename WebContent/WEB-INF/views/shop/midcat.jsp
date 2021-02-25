<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="/css/shop.css">
<c:forEach var="seller" items="${seller}">
	<ul class="midcatBorder_Top">
		<li onclick="getAllitemList('${seller.sellerDomain}')" id="all">전체
			</td>
		<li onclick="getCategory('의류','${seller.sellerDomain}')">의류
			</td>
		<li onclick="getCategory('악세서리','${seller.sellerDomain}')">악세서리
			</td>
		<li onclick="getCategory('케이스','${seller.sellerDomain}')">케이스
			</td>
		<li onclick="getCategory('생활용품','${seller.sellerDomain}')">생활용품
			</td>
	</ul>
	<div class="table">
		<table class="nes-table is-bordered is-centered" width="1100">
			<tr class="midcatBorder_Content">
				<td class="midcatBorder_Left"></td>
				<td class="midcatBorder_Right"></td>
			</tr>
		</table>
		<button type="button" class="nes-btn is-primary"
			onclick="location.href='/shop/write'" style="width: 1100px">상품등록</button>
	</div>
	<script>
					var welcome = "${msg}";
					if (welcome != '') {
						alert(welcome);
					};
					var value = "<c:out value="${seller.sellerDomain}"/>";
					$(document).ready(function() {
						getAllitemList(value);
					});
				</script>
	<script src="/js/shopSystem.js">
					
				</script>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</c:forEach>

