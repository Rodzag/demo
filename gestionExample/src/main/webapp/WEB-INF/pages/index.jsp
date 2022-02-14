<%@page import="java.util.Date"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="java">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${pageContext.request.contextPath}/styles/style.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Example MVC</title>
<style>

.label1
{

display: inline-block; 
width: 120px;

}

.error{color:red}  

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
			<%= new Date() %>
		</div>
	</div>
	<div class="main" style="margin-top:-200px">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">

        <br>

        <a href="?lang=en"><img src="${pageContext.request.contextPath}/img/en.png" style="width: 60px;height: 70px"/></a>
        <a href="?lang=fr"><img src="${pageContext.request.contextPath}/img/fr.jpg" style="width: 50px;height: 40px"/> </a>
        
        <br>
				<h2><s:message code="label.titre"></s:message></h2>
				<br>

				<sf:form action="index" method="POST" modelAttribute="user">
						<sf:label class="label1" path="login"><s:message code="label.login"></s:message></sf:label>
						<sf:input  type="text" path="login" />
						<sf:errors path="login" cssClass="error"/>
						<br>
						
						<sf:label class="label1" path="password"><s:message code="label.pass"></s:message></sf:label>
						<sf:input  path="password" type="password" />
						<sf:errors path="password" cssClass="error"/>
						<br>
					<br> 
					<input type="submit" value=<s:message code="label.titre"></s:message>>

				</sf:form>
				<h4>${message}</h4>
				<br>
			</div>
			
			

		</div>
	</div>
</body>

</html>