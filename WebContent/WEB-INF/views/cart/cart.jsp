<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link rel="stylesheet" type="text/css" href="/css/cart.css">
<div class="cartpage">
	<table class="nes-table is-bordered is-centered">
		<c:set var="sum" value="0"/>
 	<c:forEach var="cart" items="${cart}">
		<tr>
			<td colspan="6"><img src="/upload/${cart.img_m}" width="100" height="100">
			${cart.itemName}
			<span class="amount">${cart.amount}개</span>
			${cart.itemPrice}원</td>
			<td><button type="button" class="nes-btn is-primary" onclick="deletefromcart(${cart.item_uid},'${sessionID}',${cart.amount})">삭제</button></td>
		</tr>
		<c:set var="sum" value="${sum + (cart.itemPrice*cart.amount)}"/>
	</c:forEach>
	 	<tr>
	 		<td colspan=6>총합계:<fmt:formatNumber pattern="###,###,###" value="${sum}"/>원</td>
	 		<input type="hidden" value="${sum}" name="sum">
	 		<td><button type="button" class="nes-btn is-primary" onclick="order()">구매</button></td>
	 	</tr>
	 	</form>
	</table>

</div>
<script src="/js/main.js">
</script>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>