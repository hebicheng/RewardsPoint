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
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<meta charset="utf-8">
		<title>SICNU ACM TEAM</title>
	</head>

	<body>
		<div class="container mian-container">
			<div class="card-head">
				<h2>SICNU ACM Team Reward Point List</h2>
			</div><br/>
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
	</body>

</html>