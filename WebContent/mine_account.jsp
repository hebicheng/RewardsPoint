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
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/mine.css">
	<script src="js/mine_account.js" type="text/javascript"></script>
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
			<div class="col-sm-2">
				<div class="list-group" id="sidebar">
					<a href="record" class="list-group-item " > Records</a>
					<a href="account" class="list-group-item leftlight"> Account</a>					
				</div>
			</div>
			<div class="card col-sm-10">
				<div class="card-body">
					<div class="card">
						<div class="card-header">
							<h4>Change password </h4>
						</div>
						<div class="card-body">
							<div class="row">
								<form class="form-horizontal col-sm-6" id="changePWDForm" method="post" action="changepwd" role="form">
								    <div class="row">
								        <div class="col-md-offset-6 col-md-12">
											<div class="form-group">
												<input type="password" class="form-control" id="newpwd" name="newpwd" placeholder="New password">
												<i class="fa fa-user"></i>
											</div>
											<div class="form-group">
												<input type="password" class="form-control" id="repwd" name="repwd" placeholder="Comfirm password">
												<i class="fa fa-lock"></i>
												<!--<a href="#" class="fa fa-question-circle"></a>-->
											</div>
								        </div>
								   </div>
									<div class="modal-footer">
										<input type="submit" class="btn btn-primary" value="Submit">
									</div>
									<c:if test="${not empty message }">
										<div class="alert alert-success" id="cpwdMessage">
											<strong>${message }</strong>
										</div>	
									</c:if>
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>