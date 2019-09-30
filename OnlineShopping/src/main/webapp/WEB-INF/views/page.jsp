<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

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

	<div class="wrapper">

		<!-- Navigation   -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">

			<!-- Loading Home Page Content -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!--Loading About Page on User Click  -->
			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!--Loading Contact Page on User Click  -->
			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

			<!--Loading AllProducts Page on User Click  -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>

			<!-- Showing Single Page on User Click show Product  -->
			<c:if test="${userClickShowProducts == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>

			<!-- Manage Product Page on User Click  -->
			<c:if test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>

			<!-- Manage Cart Page on User Click  -->
			<c:if test="${userClickShowCart== true }">
				<%@include file="cart.jsp"%>
			</c:if>

		</div>

		<!-- Footers Comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/jquery-1.10.2.js"></script>

		<!--  JQuery Validator Plugin-->
		<script src="${js}/jquery.validate.js"></script>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.js"></script>
		<script src="${js}/bootstrap.min.js"></script>

		<!--JQuery DataTables  Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTables Bootstrap script -->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!--  Bootbox  script -->
		<script src="${js}/bootbox.min.js"></script>

		<!-- Self coded JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
