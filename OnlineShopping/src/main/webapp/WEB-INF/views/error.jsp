<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.css" rel="stylesheet">
<%-- <link href="${css}/bootstrap.min.css" rel="stylesheet"> --%>

<!-- Bootstrap superHero theme -->
<link href="${css}/bootstrap-cerulean-theme.css" rel="stylesheet">

<!-- DataTables Bootstrap -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS  -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

		<!-- Navigation   -->
	<div class="wrapper">

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!--Brand and toggle are grouped for better mobile display -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>
		</nav>
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12"></div>
					<div class="jumbotron">
						<h1>${errorTitle}</h1>
						<hr/>
						
						<blockquote style="word-wrap:break-word">
							${errorDescription}
						</blockquote>
					</div>
				</div>

			</div>
		</div>

		<!-- Footers Comes here -->
		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>
