<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

.img2 {
	max-width: 40px;
	max-height: 40px;
	margin-bottom: 5px;
	margin-top: 5px;
	margin-left: 25px;
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

table {
	border: 1px solid black;
	padding: 0px;
	width: 100%;
}

th, td {
	border: 1px solid black;
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

.popup {
	float: right;
}

---------------------



.open-button {
	background-color: #555;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	opacity: 0.8;
	position: fixed;
	bottom: 23px;
	right: 28px;
	width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
	display: none;
	position: fixed;
	bottom: 0;
	right: 15px;
	border: 3px solid #f1f1f1;
	z-index: 9;
}

/* Add styles to the form container */
.form-container {
	max-width: 300px;
	padding: 10px;
	background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	border: none;
	background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus
	{
	background-color: #ddd;
	outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
	background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}

.croix {
	background-image:
		url(73060436-élément-de-signe-de-croix-icône-de-grunge-x-rouge-isolé-sur-fond-blanc-mark-design-graphique-bouton-.jpeg);
	border: none;
	background-color: transparent;
	width: 40px; /* largeur à spécifier */
	height: 40px; /* longueur à spécifier */
	cursor: pointer;
}
</style>
<script src="https://kit.fontawesome.com/86a95d9f82.js"></script>
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
				<a href="http://localhost:8080/gestionExample/Connexion.jsp">Accueil</a>

			</section>
			<section class="categorie">
				<a href="">Gestion des employes</a>
				<ul>
					<li><a href="http://localhost:8080/gestionExample/New.jsp">Ajouter un employe</a></li>
					<li><a href="http://localhost:8080/gestionExample/new">Afficher tous les employes</a></li>
				</ul>

			</section>
			<section class="categorie">
				<form action="http://localhost:8080/gestionExample/cherche">
					<input type="text" id="text"
						style="width: 200px; margin-top: 5px; text-align: center"
						name="text" /> <input type="submit" value="Rechercher" />
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

						<h2>Liste des employes :</h2>
						<h4>${Message}</h4>
						<br>
						<table>
							<tr>
								<th>Prenom</th>
								<th>Nom</th>
								<th>Titre</th>
								<th>Departement</th>
								<th>Date de debut</th>
								<th>Modifier</th>
								<th>Supprimer</th>
							</tr>
							<c:forEach items="${list}" var="e">
								<tr>
									<td>${e.firstName}</td>
									<td>${e.lastName}</td>
									<td>${e.title}</td>
									<td>${e.department.getName()}</td>
									<td><fmt:formatDate value="${e.startDate}"
											pattern="yyyy-MM-dd" /></td>

									<td><a
										href="http://localhost:8080/gestionExample/up?i=${e.empId}">
											<i class="fas fa-edit"
											style="height: 40px; width: 40px; margin-top: 20px"></i>
									</a></td>
									<td><a
										href="http://localhost:8080/gestionExample/change?i=${e.empId}&m=del">
											<i class="fas fa-trash-alt"
											style="height: 40px; width: 40px; margin-top: 20px"
											onclick="return confirm('Are you sure you want to delete?')"></i>
									</a></td>


								</tr>
							</c:forEach>
						</table>

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




	<script>
		function openForm(id) {
			document.getElementById("myForm").style.display = "block";
		}

		function closeForm() {
			document.getElementById("myForm").style.display = "none";
		}

		function openFormDel() {
			document.getElementById("myFormDel").style.display = "block";
		}

		function closeFormDel() {
			document.getElementById("myFormDel").style.display = "none";
		}
	</script>
</body>
</html>
