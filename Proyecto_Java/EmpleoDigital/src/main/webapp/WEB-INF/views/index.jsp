
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<html lang="es">
<head>

	<meta charset="UTF-8">
	<title>Bienvenido</title>
	<meta name="description" content="Plataforma organizativa de cursos formativos"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="distribution" content="global">
	<meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
	<meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
	<meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
	<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script> 
	<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>

</head>
<body>
<!-- Cabecera con bootstrap 3.3.7 , distribucion 4, 4, 4, // Logos corporativos-->

<header id="header" class="Cabecera">
		
		<div class="container-fluid">
			
			<div class="row">
				<div class="col-md-4">
				
					<img id="logo izquierda" src="resources/img/empleo.png" >

				</div>

				<div class="col-md-4">

					<h1 align="center">Plataforma de formaciones</h1> 

				</div>

				<div class="col-md-4">

					<img id="logo derecha" src="resources/img/fundacion.png" align="right">

				</div>

			</div>


		</div>
			
</header>
<!--Bootstrap 6-6 // Video de telefonica  y boton de acceso al login que desplegara una modal, el boton es una imagen por comodidad-->
<section style=" background-color: #8DC6CD; width: 100%; height: 60%;">
	
<div class="container-fluid"></div>

	<div class="row">

			<div class="col-md-6">

					<video autoplay loop width="85%" height="80%">
				
						<source src="resources/img/animacion_ogg.webm" type='video/webm; codecs="vp8, vorbis"'>

					</video>
			
			
			</div>	

		<div class="col-md-6">
				
  	
  				<!-- imagen de entrar, hace de boton -->
  
  					<img  src="resources/img/Enter.png"  class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" VSPACE=280 HSPACE=150  style="padding: 1px; background-color: #000000 " >

 
		</div>


			

	</div>
	
				 <!-- Modal -->
			  <div class="modal fade" id="myModal" role="dialog">
			    <div class="modal-dialog">
			    
				      <!-- Modal content-->
				    <div class="row">
						<div class="login">
				 			 <div class="login-triangle"></div>
				  
				 			 <h2 class="login-header">Introduzca sus datos</h2>
	
							  <form class="login-container" action="VCIndex" method="POST">
							  	<p><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></p>
							    <p><input type="text" placeholder="Usuario"></p>
							    <p><input type="password" placeholder="Contraseña"></p>
							    <p><input type="submit" value="Acceder"></p>
							  </form>
						</div>
					</div>
			      
			    </div>
			  </div>
  				<!-- Fin modal -->

</section>
<!--Logo del equipo , y nombre y linkedin de cada uno// Distribucion de bootstrap 2-1-3-3-3-->

<footer id="footer" class="pie">

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		
			<img id="logo izquierda" src="resources/img/LogoEquipo.png" width= 100%; height= 100%;>

		</div>

		<div class="col-md-1">
		<br>
		<br>
			<a>EQUIPO JAVA TOLETVM</a>

		</div>

		<div class="col-md-3" align="center">	
			<br>
			<br>
				<a href="https://www.linkedin.com/in/josedelcastillomartínez/" target="_blank">Jose del Castillo Martinez de la Casa </a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Benítez</a>
			
			</div>
		<div class="col-md-3" align="center">
			
			<br>
			<a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig	</a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/vicentenavarrogarcia/" target="_blank">Vicente Navarro Garcia</a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/eduardo-redondo/" target="_blank">Eduardo Redondo Pérez</a>
		
			
		</div>
		
		<div class="col-md-3" align="center">
			<br>
			<br>
				<a href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara Sanabria Pérez</a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta Garcia</a>
		</div>

		</div>

	</div>
</div>
		



</footer>


</body>

</html>