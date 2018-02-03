<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<!--bootstrap-->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<!--validate-->
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>

	<!--local-->
	<script src="js/ajax.js"></script>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/mine.css">
	<meta charset="utf-8">
	<title>SICNU ACM TEAM</title>
</head>

<body>
	<nav class="navbar navbar-expand-sm main-navigation navbar-light">
		<div class="container">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="navbar-brand" href="#">SICNU</a>
				</li>
				<li class="nav-item">
					<a class="nav-link nav-current" href="Rank">Rank</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Contests">Contests</a>
				</li>
				<c:choose>
					<c:when test="${type == 0}">
						<li class="nav-item">
							<a class="nav-link" href="#">Teamer</a>
						</li>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${type == 1}">
						<li class="nav-item">
							<a class="nav-link" href="record">Mine</a>
						</li>
					</c:when>
				</c:choose>
			</ul>
			<c:choose>
				<c:when test="${empty type }">
					<!-- 未登录 -->
					<a href="login">
						<button type="button" class="btn btn-outline-secondary btn-sm">Login </button>
					</a>
				</c:when>
				<c:otherwise>
					<!-- 登录成功 -->
					<ul class="navbar-nav">
						<li class="nav-item">
							<img src="img/avatar.gif" class="rounded-circle" alt="head" style="width:40px;">
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
								${user}
							</a>
							<div class="dropdown-menu">
								<a class="dropdown-item" href="dologout">Logout</a>
							</div>
						</li>
					</ul>
					
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class=" col-sm-2">
				<div class="list-group" id="sidebar">
					<a href="record" class="list-group-item leftlight" > Records</a>
					<a href="account" class="list-group-item"> Account</a>					
				</div>
			</div>
			<div class="card col-sm-10">
				<c:choose>
					<c:when test="${empty data }">
						<div class="card-body">
							no record.
						</div>
					</c:when>
					<c:otherwise>
						<div class="card-body">
							
								<c:forEach var="data" items="${data}">
								<div class="card">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-4">
												 <div class="badge badge-pill badge-warning">${data.updateTime}</div>
												 <div class="badge badge-pill badge-info">${data.contest}</div>
											</div>
											<div class="col-sm-2">
												 <button type="button" class="btn btn-primary">
												 	Rank <span class="badge badge-light">${data.rank}</span>
												 </button>
											</div>
											<div class="col-sm-2">
												 <button type="button" class="btn btn-success">
												 	Accpted <span class="badge badge-light">${data.ac}</span>
												 </button>
											</div>
											<div class="col-sm-2">
												 <button type="button" class="btn btn-danger">
												 	First Blood <span class="badge badge-light">${data.fb}</span>
												 </button>
											</div>
											<div class="col-sm-2">
												 <button type="button" class="btn btn-secondary">
												 	Sole <span class="badge badge-light">${data.onlyAC}</span>
												 </button>
											</div>
										</div>
									</div>
								</div>
								</c:forEach>
						</div>
					
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>

</html>