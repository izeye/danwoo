<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="Danwoo">
		<meta name="author" content="izeye">
		
		<link rel="shortcut icon" href="<c:url value="/resources/assets/ico/favicon.ico" />">
		
		<title>Danwoo: <sitemesh:write property="title" /></title>

		<link rel="stylesheet" href="<c:url value="/resources/lib/bootstrap/3.1.0/css/bootstrap.min.css" />">
		
		<style type="text/css">
			.mainBody {
				padding: 10px;
			}
		</style>
		
		<script src="<c:url value="/resources/lib/jquery/2.1.0/jquery-2.1.0.min.js" />"></script>
		
		<!--[if lt IE 9]>
			<script src="<c:url value="/resources/lib/html5shiv/3.7.0/html5shiv.js" />"></script>
			<script src="<c:url value="/resources/lib/respondjs/1.4.2/respond.min.js" />"></script>
		<![endif]-->
		
		<sitemesh:write property="head" />
	</head>
	<body>
		<ul class="nav nav-tabs">
			<li><a href="<c:url value="/" />">Home</a></li>
			<li><a href="<c:url value="/messages" />">Messages</a></li>
		</ul>
		<div class="mainBody">
			<sitemesh:write property="body" />
		</div>
		
		<script src="<c:url value="/resources/lib/bootstrap/3.1.0/js/bootstrap.min.js" />"></script>
	</body>
</html>
