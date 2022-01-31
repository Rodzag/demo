<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Project bastien</title>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->

<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<style>
img {
	max-width: 25px;
	max-height: 25px;
	display: block;
	margin-left: 120px;
}

.menu {
	text-align: center;
	display: flex;
}

.menu .categorie {
	flex: 1;
	background: black;
	position: relative;
	/* pour être la «racine» du sous-menu en absolute */
}

.menu .categorie ul {
	max-height: 0;
	overflow: hidden;
	transition: 0;
	position: absolute;
	padding: 0;
	margin: 0;
	list-style: none;
	width: 100%; /* pour avoir la même largeur que la «racine» */
}

.menu .categorie:hover ul {
	max-height: 50em;
	transition: 1s;
}

.menu h3, .menu a {
	display: block;
	margin: 0;
	padding: .5em 1.5em;
	font-size: inherit;
	color: white;
	background-color: black;
	text-decoration: none;
	box-sizing: border-box;
}

.menu .categorie:hover h3 {
	color: white;
	background-color: orange;
}

.menu a:hover {
	color: white;
	background-color: orange;
}
</style>
</head>
<body>
	<header>
		<h1 class="site-heading text-center text-faded d-none d-lg-block"
			style="padding-top: 0px">
			<span class="site-heading-upper">Project JEE</span>
		</h1>
	</header>
	<section>

		<nav class="menu">
			<section class="categorie">
				<a href="http://localhost:8080/gestionExample/index.jsp">Accueil</a>

			</section>
			<section class="categorie">
				<a href="">Gestion des employes</a>
				<ul>
					<li><a href="http://localhost:8080/gestionExample/New.jsp">Ajouter
							un employe</a></li>
					<li><a href="http://localhost:8080/gestionExample/new">Afficher
							tous les employes</a></li>
				</ul>
			</section>
			<section class="categorie">
			<form action="http://localhost:8080/gestionExample/cherche">
				<input type="text" id="text" style="width: 200px; margin-top:5px; text-align: center" name="text"/>
				<input type="submit" value="Rechercher"/>
			</form>

			</section>
			<section class="categorie">
				<a href="http://localhost:8080/gestionExample/logout"> <img
					src="http://localhost:8080/gestionExample/assets/img/kisspng-abmeldung-button-icon-shut-cliparts-5a89cae38f35c7.1285697615189798115866.png"></a>

			</section>
		</nav>
		<div class="container">
			<div class="intro"></div>
		</div>
	</section>
	<section class="page-section cta">
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<div class="cta-inner bg-faded text-center rounded">

						<h3>Connexion</h3>

						<form action="/gestionExample/IdentifServelt" method="post">

							<label for="login">Login:</label><br> <input type="text"
								style="text-align: center" id="Login" name="Login"><br>
							<label for="passWord">PassWord:</label><br> <input
								type="password" id="passWord" name="passWord"
								style="text-align: center"><br> <br> <input
								type="submit" value="Connexion">
							<h1 style="color: red">${MessageError}</h1>
						</form>
						<p>--------------------</p>
						<form action="/gestionExample/IdentifServelt" method="get">
							<label for="login">Login:</label><br> <input type="text"
								style="text-align: center" id="Login" name="Login"><br>
							<label for="passWord">PassWord:</label><br> <input
								type="password" id="passWord" name="passWord"
								style="text-align: center"><br> <br>
							<input type="submit" value="Inscription"> <br>
							<h1>${Message}</h1>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="footer text-faded text-center py-5">
		<div class="container">
			<p class="m-0 small">Copyright &copy; Inti.formation 2022</p>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>
</html>
