<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--bootstrap-->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<!--validate-->
	<script src="js/jquery.validate.min.js" type="text/javascript"></script>

	<!--local-->
	<script src="js/ajax.js"></script>
	<script src="js/adminContest.js" type="text/javascript"></script>
	<script src="js/adminCheck.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<title>${contest.name }</title>
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
		<div class="card">
			<div class="card-body">
				<h2 >${contest.name }</h2>
				<p class="badge badge-primary">${contest.content }</p>
				<p class="badge badge-info">${contest.oj }</p>
				<p class="badge badge-success">${contest.time }</p>
				<c:if test="${contest.type == 0 }">
					<p class="badge badge-dark">${contest.num }</p>	
				</c:if>
				<p><a href="${contest.url }">${contest.url }</a></p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Username</th>
							<th>name</th>
							<c:choose>
								<c:when test="${contest.type == 0 }">
									<th>Accepted</th>
									<th>rank</th>
									<th>Sole</th>
									<th>First Blood</th>
								</c:when>
								<c:otherwise>
									<th>Home</th>
									<th>rating</th>
								</c:otherwise>
							</c:choose>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="index" value="1"></c:set>
						<c:forEach var="data" items="${data}">
							<c:choose>
								<c:when test="${data.isUpdate}">
									<tr>
										<td>${index}</td>
										<td>${data.username}</td>
										<td>${teamers[index-1].name }</td>
										<c:choose>
											<c:when test="${contest.type == 0 }">
												<td>${data.ac}</td>
												<td>${data.rank }</td>
												<td>${data.onlyAC }</td>
												<td>${data.fb}</td>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${data.type == 1 }">
														<td><a href="http://codeforces.com/profile/${teamers[index-1].cf }">${teamers[index-1].cf }</a></td>		
													</c:when>
													<c:otherwise>
														<td><a href="http://atcoder.jp/user/${teamers[index-1].atcoder }">${teamers[index-1].atcoder }</a></td>
													</c:otherwise>
												</c:choose>
												<td>${data.rating}</td>
											</c:otherwise>
										</c:choose>
										<c:if test="${type == 0}">
											<td><button type="button" class="btn btn-primary btn-sm update" data-toggle="modal" data-target="#Update">Update</button></td>
										</c:if>
										<c:if test="${type == 1}">
											<td>${data.showScore }</td>
										</c:if>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td>${index}</td>
										<td>${data.username}</td>
										<td>${teamers[index-1].name }</td>
										<c:choose>
											<c:when test="${contest.type == 0 }">
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${data.type == 1 }">
														<td><a href="http://codeforces.com/profile/${teamers[index-1].cf }">${teamers[index-1].cf }</a></td>		
													</c:when>
													<c:otherwise>
														<td><a href="http://atcoder.jp/user/${teamers[index-1].atcoder }">${teamers[index-1].atcoder }</a></td>
													</c:otherwise>
												</c:choose>
												<td></td>
											</c:otherwise>
										</c:choose>
										<c:if test="${type == 0}">
											<td><button type="button" class="btn btn-primary btn-sm update" data-toggle="modal" data-target="#Update">&nbsp&nbsp&nbspSet&nbsp&nbsp&nbsp&nbsp</button></td>
										</c:if>
										<c:if test="${type == 1}">
											<td>${data.score }</td>
										</c:if>
									</tr>
								</c:otherwise>
							</c:choose>
							<c:set var="index" value="${index+1}" ></c:set>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- 更新 -->
	<div class="modal fade" id="Update">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form role="form" id="updateForm" action="UpdateRecord" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Update</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
				
					<div class="modal-body">
						<div class="d-none">
							<input type="text" name="id" value="${contest.id}" />
							<input type="text" name="username" id="username">
						</div>
						
						<c:choose>
							<c:when test="${contest.type == 0 }">
								<div class="form-group">
									<label for="ac">过题数:</label>
		    						<input type="text" class="form-control" id="ac" name="ac">
								</div>
							    
							    <div class="form-group">
									<label for="rank">rank:</label>
		    						<input type="text" class="form-control" id="rank" name="rank">
								</div>
								
								<div class="form-group">
									<label for="onlyAC">唯一AC题数:</label>
		    						<input type="text" class="form-control" id="onlyAC" name="onlyAC">
								</div>
								
								<div class="form-group">
									<label for="fb">一血题数:</label>
		    						<input type="text" class="form-control" id="fb" name="fb">
								</div>
							</c:when>
							<c:otherwise>
								<div class="form-group">
									<label for="rating">rating:</label>
		    						<input type="text" class="form-control" id="rating" name="rating">
								</div>
							</c:otherwise>
						</c:choose>
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