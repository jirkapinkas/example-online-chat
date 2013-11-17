<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp">
	<jsp:param value="Chatroom List" name="title" />
	<jsp:param value="list" name="page" />
</jsp:include>

<h2>Chatrooms:</h2>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>name</th>
			<th>description</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${chatrooms}" var="chat">
			<tr>
				<td><a href="detail.html?id=${chat.id}"> ${chat.name}</a></td>
				<td>${chat.description}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="layout/footer.jsp" />
