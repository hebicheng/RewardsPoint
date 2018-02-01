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
	<script src="js/adminCheck.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
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
					<a class="nav-link nav-current" href="admin">Rank</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="admin">Contests</a>
				</li>
			</ul>
			<c:choose>
				<c:when test="${empty admin }">
					<!-- 未登录 -->
					<a href="login">
						<button type="button" class="btn btn-outline-secondary btn-sm">Login </button>
					</a>
				</c:when>
				<c:otherwise>
					<!-- 登录成功 -->
					<!-- <li class="nav-item">
						<img src="img/avatar.gif" class="rounded-circle" alt="head" style="width:40px;">
					</li> -->
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
							${admin }
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="DoLogout">退出登录</a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<div class="card w-75 mx-auto">
		<div class="card-body">
			<div class="row">
			  	<div class="col-8">
			  		<h2>Contests</h2>
			  	</div>
			  	<div class="col-4">
			  		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Create">创建比赛</button>
			  	</div>
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
							<td><a href="ac?id=${contest.id }">${contest.name}</a></td>
							<c:set var="index" value="${index+1}" ></c:set>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
<%-- 	<div class="container mian-container">
		<div class="list-group left-side">
			<c:forEach var="teamers" items="${teamers}">
				<c:choose>
					<c:when test="${teamers.name eq selectteamer.name}">
						<a href="admin?name=${teamers.name}" class="list-group-item list-group-item-success"> ${teamers.name} </a>
					</c:when>
					<c:otherwise>
						<a href="admin?name=${teamers.name}" class="list-group-item"> ${teamers.name} </a>
					</c:otherwise>
				</c:choose>	
			</c:forEach>
		</div>
		<div class="right-side">
			<div class="card-head user">
				<h1>${selectteamer.name}<h1>
			</div>
			<div class="card-body">
				<div class="card add-point">
					<div class="card-head user">
						<h2>Bonus Point<h2>
					</div>
					<div class="card-body">
						<form class="form-horizontal" id="addForm" method="post" action="addpoint" role="form" value="${selectteamer.name}">
						    <div class="row">
						        <div class="col-md-offset-6 col-md-12">
						        	<input type="hidden" name="oprname" value="${selectteamer.name}">
									<div class="form-group">
										<input type="text" class="form-control" id="addscore" name="score" placeholder="point">
										<i class="fa fa-user"></i>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="addreason" name="reason" placeholder="reason">
										<i class="fa fa-lock"></i>
										<!--<a href="#" class="fa fa-question-circle"></a>-->
									</div>
						        </div>
						   </div>
							<div class="modal-footer">
								<c:if test="${not empty addmessage }">
									<div class="alert alert-success" id="asaved">
										<strong>${addmessage }</strong>
									</div>	
								</c:if>
								<input type="submit" class="btn btn-primary" value="Save">
							</div>
						</form>
					</div>
				</div>
				<div class="card reduce-point">
					<div class="card-head user">
						<h2>Deduction<h2>
					</div>
					<div class="card-body">
						
						<form class="form-horizontal" id="reduceForm" method="post" action="reducepoint" role="form">
						    <div class="row">
						        <div class="col-md-offset-6 col-md-12">
						        	<input type="hidden" name="oprname" value="${selectteamer.name}">
									<div class="form-group">
										<input type="text" class="form-control" id="reducescore" name="score" placeholder="point">
										<i class="fa fa-user"></i>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" id="reducereason" name="reason" placeholder="reason">
										<i class="fa fa-lock"></i>
										<!--<a href="#" class="fa fa-question-circle"></a>-->
									</div>
						        </div>
						   </div>
							<div class="modal-footer">
								<c:if test="${not empty remessage }">
									<div class="alert alert-success" id="rsaved">
										<strong>${remessage }</strong>
									</div>	
								</c:if>
								<input type="submit" class="btn btn-primary" value="Save">
							</div>
						</form>
					</div>
				</div>
			</div>	
		</div>
	</div> --%>
</body>
</html>
