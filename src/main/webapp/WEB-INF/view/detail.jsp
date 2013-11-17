<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp">
	<jsp:param value="Chatroom List" name="title" />
	<jsp:param value="list" name="page" />
</jsp:include>

<h2>${chatroom.name}</h2>
${chatroom.description}<br><br>

<form action="" method="post">
	<input type="hidden" name="id" value="${chatroom.id}">
	<div class="form-group">
		<div class="col-sm-5">
			<input type="text" class="form-control" placeholder="Message" name="message" autofocus="autofocus" />
		</div>
		<div class="col-sm-5">
			<input type="submit" class="btn btn-primary" />
		</div>
	</div>
</form>
<br><br><br>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script>

	var repeatme = function print() {
		$.ajax({
			url : '<spring:url value="/chatroom/detail/${chatroom.id}.json" />',
			cache : false
		}).done(function(data) {
			$(".messages").html("");
			$.each(data.chatmessages, function(index, value) {
				$(".messages").append(value.message + "<br>");
			});
		});
	};

	$(document).ready(function() {
		repeatme();
		setInterval(repeatme, 1000);
	});
</script>

<div class="messages"></div>

<jsp:include page="layout/footer.jsp" />
