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
			</ul>
			<c:choose>
				<c:when test="${empty name }">
					<!-- 未登录 -->
					<a href="login">
						<button type="button" class="btn btn-outline-secondary btn-sm">Login </button>
					</a>
				</c:when>
				<c:otherwise>
					<!-- 登录成功 -->
					<li class="nav-item">
						<img src="img/avatar.gif" class="rounded-circle" alt="head" style="width:40px;">
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
							${name }
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="DoLogout">退出登录</a>
						</div>
					</li>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	
	<div class="container">
		<div class="card">
			<div class="card-body">
				<h2>SICNU ACM Team Reward Point List</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>name</th>
							<th>Grade</th>
							<th>SICNUOJ</th>
							<th>Codeforces</th>
							<th>Atcoder</th>
							<th>Reward Point</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="index" value="1"></c:set>
						<c:forEach var="data" items="${data}">
							<tr>
							<td>${index}</td>
							<td>${data.name}</td>
							<td>${data.grade}</td>
							<td><a href="https://acm.sicnu.edu.cn/user-home?username=${data.sicnuoj}">${data.sicnuoj}</a></td>
							<td><a href="http://codeforces.com/profile/${data.cf}">${data.cf}</a></td>
							<td><a href="http://atcoder.jp/user/${data.atcoder}">${data.atcoder}</a></td>
							<td>${data.point}</td>
							<c:set var="index" value="${index+1}" ></c:set>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>