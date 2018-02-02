<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							<a class="nav-link" href="#">Mine</a>
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
		<div class="card">
			<div class="card-body">	
				<div class="row">		
				 	<div class="col-10">
				  		<h2>Contests</h2>
				  	</div>
				  	<c:if test="${type == 0}">
						<div class="col-2">
					  		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Create">创建比赛</button>
					  	</div>
					</c:if>
				 </div>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>name</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="index" value="1"></c:set>
						<c:forEach var="contest" items="${contests}">
							<tr>
								<td>${index}</td>
								<td><a href="contest?id=${contest.id }">${contest.name}</a></td>
								<c:set var="index" value="${index+1}" ></c:set>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>	
	<!-- 创建比赛 -->
	<div class="modal fade" id="Create">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="createForm" action="CreateContest" method="post">
					<div class="modal-header">
						<h4 class="modal-title">创建比赛</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<div class="form-group">
							<label for="cName">比赛名:</label>
    						<input type="text" class="form-control" id="cName" name="cName">
						</div>
						
						<div class="form-group">
					      	<label for="cContent">说明:</label>
					      	<textarea class="form-control" rows="5" id="cContent" name="cContent"></textarea>
					    </div>
					    
					    <div class="form-group">
							<label for="cWeight">比赛权重:</label>
    						<input type="text" class="form-control" id="cWeight" name="cWeight" value="1">
						</div>
						
						<div class="form-group">
							<label for="cOj">oj:</label>
    						<input type="text" class="form-control" id="cOj" name="cOj">
						</div>
						
						<div class="form-group">
							<label for="cUrl">地址:</label>
    						<input type="text" class="form-control" id="cUrl" name="cUrl">
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-info" value="创建" id="mkInbox">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
					</div>
					<!-- <div class="alert alert-danger" id="createInboxInfo">
						<strong></strong>
					</div>	 -->
				</form>
			</div>
		</div>
	</div>
</body>

</html>