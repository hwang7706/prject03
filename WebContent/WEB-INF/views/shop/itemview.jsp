<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<script type="text/javascript" src="/js/shopSystem.js"></script>
<link rel="stylesheet" type="text/css" href="/css/itemview.css">	
		
		<c:forEach var="item" items="${item}">
		
		<div class="order">
			<table class="nes-table is-bordered is-centered">
				<tr>
					<td rowspan=7><img src="/upload/${item.img_m}" width="200" height="300"></td>
					<td></td>
				</tr>
				<tr>
					<td><h2>${item.itemName}</h2></td>
				</tr>
				
				<tr>
					<td>${item.itemTitleCategory}</td>
				</tr>
				
				<tr>
					<td><p>${item.itemBottomCategory}</p></td>
				</tr>
				<tr>
					<td class="price">가격:${item.itemPrice}</td>
				</tr>
				<tr>
					<td><p><button type="button" class="nes-btn is-success" onclick="plus(${item.itemUID},${item.itemPrice})">PLUS</button>
			<input type="number" value="1" size="10" id="count">
			<button type="button" class="nes-btn is-error" onclick="minus(${item.itemUID},${item.itemPrice})">MINUS</button></p></td>
				</tr>
				<tr>
					<td class="addtocart"><button type="button" class="nes-btn is-primary" onclick="test(${item.itemUID},'${sessionID}','${item.itemBottomCategory}','${item.itemName}','${item.img_m}','${item.itemPrice}')">add to cart</button></td>
				</tr>
				
			</table>
			</div>
		</c:forEach>
			
			
			
			
			
		
		
	</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>