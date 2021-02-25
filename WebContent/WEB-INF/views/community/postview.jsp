<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<link rel="stylesheet" type="text/css" href="/css/postview.css">
<div class="postview">
	<table class="nes-table is-bordered is-centered">
		<tr class="title">
			<td><p class="titlestyle">${detail.postTitle}</p></td>
		</tr>
		<tr>
			<td><p class="">${detail.postUsername}</p></td>
		</tr>	
		<tr>
			<td><p class="">${detail.postContent}</p>
			<img src="/upload/${detail.postImage}" width="50" height="100">
			</td>
		</tr>
	</table>
</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>