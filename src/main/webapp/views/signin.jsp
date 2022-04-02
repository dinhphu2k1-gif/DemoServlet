<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="utf-8" />
<link rel="icon" href="logo.png" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="theme-color" content="#000000" />

<link
	href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css" />

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Sign in</title>
</head>
<body>
	<div class="container mx-5">
		<form action="<%=request.getContextPath()%>/sign-in"
			method="post">
			<h1 class="my-4 text-center">Sign in</h1>
			<div class="form-group">
				<label for="email">Email address</label> <input type="email"
					class="form-control mb-4" id="email" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="password" class="label">Password</label> <input
					type="text" class="form-control mb-4" id="password"
					placeholder="Password" name="password">

			</div>

			<div class="text-center">
				<p>
					<a href="#">Forgot password?</a>
				</p>

				<div class="clearfix"></div>

				<button type="submit" class="btn btn-success my-3">Sign in</button>
				<p>
					Don't have an account? <a href="#">Sign up</a>
				</p>
			</div>
		</form>

	</div>
</body>
</html>