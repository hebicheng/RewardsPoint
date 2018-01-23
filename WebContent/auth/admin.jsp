<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<!--bootstrap-->
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

		<!--validate-->
		<script src="js/jquery.validate.min.js" type="text/javascript"></script>

		<!--local-->
		<script src="js/ajax.js"></script>
		<script src="js/adminCheck.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="css/admin.css">
		<meta charset="utf-8">
		<title>SICNU ACM TEAM</title>
	</head>
	<body>
		<div class="container mian-container">
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
		</div>
	</body>
</html>