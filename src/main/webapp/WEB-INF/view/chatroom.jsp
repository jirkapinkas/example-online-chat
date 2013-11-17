<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp">
	<jsp:param value="New Chatroom" name="title" />
	<jsp:param value="chatroom" name="page" />
</jsp:include>

<h2>new chatroom:</h2>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form cssClass="form-horizontal" commandName="chatroom">
	<c:if test="${param.success}">
		<div class="form-group">
			<div class="col-sm-6">
				<div class="alert alert-success">
					Successfully saved!
				</div>
			</div>
		</div>
	</c:if>

	<form:errors path="name" />
	<div class="form-group">
		<label class="col-sm-1 control-label">Name:</label>
		<div class="col-sm-5">
			<form:input cssClass="form-control" placeholder="Name" path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword" class="col-sm-1 control-label">Description:</label>
		<div class="col-sm-5">
			<form:input cssClass="form-control" placeholder="Description" path="description" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-5">
			<input type="submit" class="btn btn-primary" />
		</div>
	</div>
</form:form>


<jsp:include page="layout/footer.jsp" />