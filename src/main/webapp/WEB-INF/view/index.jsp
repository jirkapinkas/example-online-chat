<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp">
	<jsp:param value="Hello" name="title" />
	<jsp:param value="index" name="page"/>
</jsp:include>

<h1>Just a simple online chat application.</h1>

<p>This project is to showcase Spring, Spring Web MVC, JSPs and
	JSTL. Based on Maven, Hibernate, HSQLDB and Twitter Bootstrap.</p>

<p>This project contains embedded HSQL database, which destroys all
	data at shutdown. If you want different database, see README.MD.
	Demo database will be re-initialized each day.</p>

<br />

<jsp:include page="layout/footer.jsp" />
