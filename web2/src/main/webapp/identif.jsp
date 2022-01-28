<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Identification</title>
</head>
<body>

<h3>Souhaitez-vous vous identifier?</h3>

<form action="ident" method="post">
				
<label for="login">Login:</label><br>
<input type="text" id="Login" name="Login"><br>
				
<label for="passWord">PassWord:</label><br>
<input  type="password" id="passWord" name="passWord"><br><br>
				
 <input type="submit" value="Connexion">
				
</form>

<h1>${Message2}${user}</h1>
<br>
<p>---------------------</p>
<br>
<h3>Souhaitez-vous plutôt vous inscrire?</h3>

<form action="ident" method="get">
				
<label for="login">Login:</label><br>
<input type="text" id="Login" name="Login"><br>
				
<label for="passWord">PassWord:</label><br>
<input  type="password" id="passWord" name="passWord"><br><br>
				
 <input type="submit" value="Inscription">
				
</form>
<br>
<p>---------------------</p>
<br>		
<form action="index.html" method="post">				
<input type="submit" value="Retour home">			
</form>

<h1>${Message}</h1>

</body>
</html>