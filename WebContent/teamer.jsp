<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script src="js/adminTeamerOpr.js" type="text/javascript"></script>
	<script src="js/adminTeamerOprUpdateCheck.js" type="text/javascript"></script>
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
							<a class="nav-link" href="teamer">Teamer</a>
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
					<a href="teamer" class="list-group-item " > Teamer</a>					
				</div>
			</div>
			<div class="card col-sm-10">
				<div class="card-body">
					<div class="card">
						<div class="card-body">
							<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#addTeamer">Add Teamer</button>
						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>#</th>
										<th>Username</th>
										<th>Name</th>
										<th>Grade</th>
										<th class="tabledisplay">Sicnu OJ</th>
										<th class="tabledisplay">Coderforces</th>
										<th class="tabledisplay">AtCoder</th>
										<th>Point</th>
										<th colspan="4" class=""></th>
									</tr>
								</thead>
								<tbody>
									<c:set var="index" value="1"></c:set>
									<c:forEach var="data" items="${teamers}">
										<tr>
										<td>${index}</td>
										<td>${data.username}</td>
										<td>${data.name}</td>
										<td>${data.grade}</td>
										<td class="tabledisplay">${data.sicnuoj}</td>
										<td class="tabledisplay">${data.cf}</td>
										<td class="tabledisplay">${data.atcoder}</td>
										<td>${data.showPoint}</td>
										<td>
											<div class="btn-group">
												
												<button type="button" class="btn btn-primary btn-sm update_l1" data-toggle="modal" data-target="#addDailyPracticePoint">Practice</button>
												<button type="button" class="btn btn-primary btn-sm update_l1" data-toggle="modal" data-target="#addAttendancePoint">Attendance</button>
												<div class="btn-group">
													<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
												      	Opr
												    </button>
											      	<div class="dropdown-menu">
												        <button type="button" class="dropdown-item update_l2_modify " data-toggle="modal" data-target="#Update">Update</button>
												        <button type="button" class="dropdown-item update_l2_delete " data-toggle="modal" data-target="#Delete">Delete</button>
											      	</div>
												</div>
											</div>
										</td>
										
										<c:set var="index" value="${index+1}" ></c:set>
									</tr>
									</c:forEach>
								</tbody>
							</table>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="Update">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="upDateTeamerForm" action="updateteamerinfo" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Update</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<c:set var="index" value="2" ></c:set>
						<div class="row">
							<div class="col-sm-6">
								<h5>Username</h5>
								<input type="text" class="form-control" id="username" name="username" placeholder="username" readonly="readonly" >
								<h5>Name</h5>
								<input type="text" class="form-control" id="name" name="name" placeholder="name">
								<h5>Grade</h5>
								<input type="text" class="form-control" id="grade" name="grade" placeholder="grade">
								<h5>Password</h5>
								<input type="password" class="form-control" id="password" name="password" placeholder="password">
							</div>
							<div class="col-sm-6">
								
								<h5>SICNU OJ</h5>
								<input type="text" class="form-control" id="sicnuoj" name="sicnuoj" placeholder="sicnuoj">
								<h5>Codeforces</h5>
								<input type="text" class="form-control" id="codeforces" name="codeforces" placeholder="codeforces">
								<h5>AtCoder</h5>
								<input type="text" class="form-control" id="atcoder" name="atcoder" placeholder="atcoder">
								
							</div>
						</div>
						
					</div>
					
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Save" id="updateBtn">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 添加用户 -->
	<div class="modal fade" id="addTeamer">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="addTeamerForm" action="addteamer" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Teamer</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<c:set var="index" value="2" ></c:set>
						<div class="row">
							<div class="col-sm-6">
								<h5>Username</h5>
								<input type="text" class="form-control" id="add_username" name="add_username" placeholder="username" >
								<h5>Name</h5>
								<input type="text" class="form-control" id="add_name" name="add_name" placeholder="name">
								<h5>Grade</h5>
								<input type="text" class="form-control" id="add_grade" name="add_grade" placeholder="grade">
								<h5>Password</h5>
								<input type="password" class="form-control" id="add_password" name="add_password" placeholder="password">
							</div>
							<div class="col-sm-6">
								
								<h5>SICNU OJ</h5>
								<input type="text" class="form-control" id="add_sicnuoj" name="add_sicnuoj" placeholder="sicnuoj">
								<h5>Codeforces</h5>
								<input type="text" class="form-control" id="add_codeforces" name="add_codeforces" placeholder="codeforces">
								<h5>AtCoder</h5>
								<input type="text" class="form-control" id="add_atcoder" name="add_atcoder" placeholder="atcoder">
								
							</div>
						</div>
						
					</div>
					
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Save" id="updateBtn">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 删除用户 -->
	<div class="modal fade" id="Delete">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<form role="form" id="deleteTeamerForm" action="deleteteamer" method="post">
					<div class="modal-header">
						<h4 class="modal-title">删除</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<div class="alert alert-danger">
						  	<strong>确认删除？</strong>
						</div>
						
					</div>
					
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Save" id="updateBtn">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 刷题-->
	<div class="modal fade" id="addDailyPracticePoint">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="addDailyPracticePointForm" action="AddDailyPracticePoint" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Daily Practice Point </h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<input type="text" class="d-none" id="dailyUsername" name="username">
						<input type="text" class="form-control" id="dppoint" name="dppoint" placeholder="Daily Practice Point">	
					</div>
					
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Save" id="updateBtn">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 考勤-->
	<div class="modal fade" id="addAttendancePoint">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="addAttendancePointForm" action="AddAttendancePoint" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Attendance Point</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<input type="text" class="d-none" id="attendUsername" name="username">
						<input type="text" class="form-control" id="attendancepoint" name="attendancepoint" placeholder="Attendance Point">		
					</div>
					
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="Save" id="updateBtn">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>