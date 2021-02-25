<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/css/community.css">
	<div class="center">
	<table class="nes-table is-bordered is-centered">
		<c:forEach var="posting" items="${posting}">
			<tr>
					<td><a href="/community/postview?postUid=${posting.postUid}">${posting.postTitle}</a>${positing.postContent}<p>${posting.postUsername}${posting.postDate}</p></td>
			</tr>
			
		</c:forEach>	
		<tr>
				<td><button class="nes-btn is-primary" onclick="location.href='/community/post'">글등록</button></td>
			</tr>
	</table>
	</div>
		

<%@ include file="/WEB-INF/views/include/footer.jsp"%>