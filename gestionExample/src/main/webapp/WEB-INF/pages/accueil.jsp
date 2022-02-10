<%@page import="java.util.Date"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Example MVC</title>
<style>
</style>
</head>

<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Application<br> JAVA EE
			</h2>
			<p>SRING MVC</p>

			<br>
			<%=new Date()%>
		</div>
	</div>
	<div class="main" style="margin-top: -200px">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
        
        <br>

        <a href="?lang=en"><img src="${pageContext.request.contextPath}/img/en.png" style="width: 60px;height: 70px"/></a>
        <a href="?lang=fr"><img src="${pageContext.request.contextPath}/img/fr.jpg" style="width: 50px;height: 40px"/> </a>
        
        <br>
				
				<h1><s:message code="label.welcome"></s:message> - ${log}</h1>

			</div>
		</div>
	</div>
</body>

</html>