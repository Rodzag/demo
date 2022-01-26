<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Random</title>
</head>

<body>
<%! public int sum(int a, int b){
	return (a+b);}
%>
	<%
	Random random = new Random();
	int randomInt = random.nextInt(3);
	if (randomInt == 0) {
	%>
	<h1>
		Random value =<%=randomInt%></h1>
	<%
	} else if (randomInt == 1) {
	%>
	<h1>
		Random value =<%=randomInt%></h1>
	<%
	} else {
	%>
	<h1>
		Random value =<%=randomInt%></h1>
	<%
	}
	%>
	
	<h1> 1+3 =<%=sum(1,3)%> </h1>


	<a href="<%=request.getRequestURI()%>">new random</a>
</body>

</html>