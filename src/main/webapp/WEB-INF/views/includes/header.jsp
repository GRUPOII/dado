<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false"%>

<html>
<head>
<title>Dado-eq2</title>
<base href="/dado-eq2/" />

<link
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css?20170308"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom -->
<link href="resources/css/custom.css" rel="stylesheet">


</head>
<body>


	<div class="container">

		<!-- Static navbar -->

		<nav
			class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="#">Web Dado-eq2</a>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="estadisticas">Estadísticas</a></li>
					</li>
				</ul>
				<!-- Menu de la derecha -->
				<ul class="nav navbar-nav navbar-right">
					<li class="nav-item active"><a class="nav-link" href="admin">Administracion</a></li>
				</ul>
			</div>
		</nav>


		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">