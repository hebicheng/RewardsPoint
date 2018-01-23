<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<script src="js/oprCheck.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="css/opr.css">
		<meta charset="utf-8">
		<title>SICNU ACM TEAM</title>
	</head>
	<body>
		<div class="container mian-container">
			<div class="list-group left-side">
				<a href="#" class="list-group-item list-group-item-success">何壁承</a>
				<a href="#" class="list-group-item list-group-item-action">任力</a>	
			</div>
			<div class="right-side">
				<div class="card-head user">
					<h1>何壁承<h1>
				</div>
				<div class="card-body">
					
					<div class="card add-point">
						<div class="card-head user">
							<h2>Bonus Point<h2>
						</div>
						
						<div class="card-body">
							
							<form class="form-horizontal" id="addForm" method="post" action="javascript:void(0)" role="form">
							    <div class="row">
							        <div class="col-md-offset-6 col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="score" name="score" placeholder="score">
											<i class="fa fa-user"></i>
										</div>
										<div class="form-group">
											<input type="password" class="form-control" id="reason" name="reason" placeholder="reason">
											<i class="fa fa-lock"></i>
											<!--<a href="#" class="fa fa-question-circle"></a>-->
										</div>
							        </div>
							   </div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" value="保存">
								</div>
							</form>
						</div>
					</div>
					<div class="card reduce-point">
						<div class="card-head user">
							<h2>Deduction<h2>
						</div>
						<div class="card-body">
							
							<form class="form-horizontal" id="reduceForm" method="post" action="javascript:void(0)" role="form">
							    <div class="row">
							        <div class="col-md-offset-6 col-md-12">
										<div class="form-group">
											<input type="text" class="form-control" id="score" name="score" placeholder="score">
											<i class="fa fa-user"></i>
										</div>
										<div class="form-group">
											<input type="password" class="form-control" id="reason" name="reason" placeholder="reason">
											<i class="fa fa-lock"></i>
											<!--<a href="#" class="fa fa-question-circle"></a>-->
										</div>
							        </div>
							   </div>
								<div class="modal-footer">
									<input type="submit" class="btn btn-primary" value="保存">
								</div>
							</form>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
	</body>
</html>
