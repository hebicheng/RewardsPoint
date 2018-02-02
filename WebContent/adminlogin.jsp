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
		<link  rel="stylesheet" type="text/css" href="css/login.css">
		<script src="js/loginCheck.js" type="text/javascript"></script>
		<meta charset="utf-8">
		<title>Admin Login</title>
	</head>
	<body>
		<div class="card container loginbox" >
			<div class="card-head">
				<h2>Admin Login</h2>
			</div>
		  	<div class="card-body">
		  		<form class="form-horizontal" id="loginForm" method="post" action="doadminlogin" role="form">
				    <div class="row">
				        <div class="col-md-offset-6 col-md-12">
							<div class="form-group">
								<input type="text" class="form-control" id="userName" name="userName" placeholder="Username">
								<i class="fa fa-user"></i>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="pwd" name="pwd" placeholder="password">
								<i class="fa fa-lock"></i>
								<!--<a href="#" class="fa fa-question-circle"></a>-->
							</div>
				        </div>
				   </div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-primary" value="登录">
					</div>
					<c:if test="${not empty message }">
						<div class="alert alert-danger" id="loginError">
							<strong>${message }</strong>
						</div>	
					</c:if>
				</form>
		  	</div>
		</div>
		
	</body>
</html>
