<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>El : expression language</title>
</head>
<body>
<jsp:useBean id="personne" class="fr.formation.inti.entity.Employee"></jsp:useBean>

<form action="emp" method="post">
				
<label for="firstname">Prenom:</label><br>
<input type="text" id="firstName" name="firstName"><br>
				
<label for="name">Nom:</label><br>
<input  type="text" id="name" name="name"><br><br>
				
 <input type="submit" value="Submit">
				
</form>

<h1>${message} ${firstName} ${name}</h1>
<h3>${message} ${employee}</h3>
		
<form action="index.html" method="post">				
<input type="submit" value="Retour home">			
</form>

</body>
</html>