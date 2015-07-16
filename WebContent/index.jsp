<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Multi Step Registration Form Template</title>

<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

</head>

<body>

	<!-- Top menu -->
	<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#top-navbar-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="top-navbar-1">
			<ul class="nav navbar-nav navbar-right">
				<li></li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>中华</strong>救助基金会
						</h1>
						<div class="description">
							<p>
								<strong>乐居专项基金</strong>
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">

						<form role="form" action="j_spring_security_check" method="post"
							class="registration-form">

							<fieldset>
								<div class="form-top">
									<div class="form-top-left">
										<h3>用户登录</h3>
									</div>
									<div class="form-top-right">
										<i class="fa fa-user"></i>
									</div>
								</div>
								<div class="form-bottom">
									<div class="form-group">
										<label class="sr-only" for="userId">用户名</label> <input
											type="text" name="userId" placeholder="用户名"
											class="form-first-name form-control" id="userId">
									</div>
									<div class="form-group">
										<label class="sr-only" for="password">密码</label> <input
											type="password" name="password" placeholder="密码"
											class="form-last-name form-control" id="password">
									</div>
									<div class="input-icon">
										<label class="sr-only" for="checkCode">密码</label>
										<input id="checkCode" name="checkCode"
											type="text" placeholder="请输入图中的验证码" autocomplete="off"
											class="login-form" />
										<img id="randImage" alt="验证码加载中" onclick="loadimage()"
											src="page/statics/checkCode.jsp" title="点击更换验证码" />
									</div>
									</br>
									<div class="form-group">
										<button type="submit" class="btn btn-next">登录</button>
										<button type="reset" class="btn green">重置</button>
									</div>
								</div>
							</fieldset>

						</form>

					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/login.js"></script>
	<script src="assets/js/scripts.js"></script>

</body>

</html>