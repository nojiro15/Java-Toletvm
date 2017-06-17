<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="es">
<head>
	<title>Plataforma de formaciones</title>
	<meta charset="UTF-8">
	<meta name="description" content="Plataforma organizativa de cursos formativos"/>
	<meta name="distribution" content="global">
	<meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Benítez, Mario Uceta Garcia" />
	<meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	 <!--script de jQuery -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="resources/css/jquery-ui.css" />
	<script src="resources/js/jquery-1.9.1.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
  	<script src="resources/js/jquery.min.js"></script>
	
</head>
<body >
<!-- Header a sustituir -->
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
<!-- Fin Header -->
<!-- Botones Formaciones y Crear/modificar -->
<nav>
<div class="row">
	<div class="col-md-2">
		<div class="btn-group">
			<button type="button" class="btn btn-primary btn-lg dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Listado de formaciones <span class="caret"></span>
			</button>
			<ul class="dropdown-menu well">
				<li><a href="#listaTodos" class="inf">Listado de todas las formaciones</a></li>
				<li><a href="#listaActivos" class="inf">Listado de formaciones en proceso</a></li>
				<li><a href="#listaFin" class="inf">Listado de formaciones finalizadas</a></li>
			</ul>
		</div>
	</div>

	<div class="col-md-2">
		<a href="VCBotonCrearModificar" class="btn btn-primary btn-lg" type="button">Crear/Modificar</a>
	</div>
</div>	
</nav>

<!-- Fin botones principales -->

<!-- Area de listados -->
<section style=" background-color: #8DC6CD; width: 100%; height: 60%">
<div class="container-fluid" style="height: 900px;margin-top: 2em;">	
	
<!-- Listado total -->	
	<div class="row " style="margin-top: 6em;">
		<div class="col-md-12 well oculto" id="listaTodos">
			<div class="list-group " >
				<a href="#" class="list-group-item active">Listado de todas las formaciones (Excel)</a>
				<c:forEach items="${listaCompleta}" var="l">
				<a href="PrepararResumen?idFormacion=${l.id}" class="list-group-item">
					
					<div class="row">
						<div class="col-md-4">${l.nombre}</div>
						<div class="col-md-4">${l.municipio.nombre}</div>
						
						
						
					</div>
				</a>
				</c:forEach>
				
			</div>
		</div>
	</div>

<!-- Listado formaciones en proceso -->

	<div class="col-md-12 well oculto" id="listaActivos">
		<div class="list-group ">
			<a href="#" class="list-group-item active">Listado de formaciones en proceso (Excel)</a>
			<c:forEach items="${listaEnCurso}" var="l">
					<a href="PrepararResumen?idFormacion=${l.id}" class="list-group-item">
						
						<div class="row">
							<div class="col-md-4">${l.nombre}</div>
							<div class="col-md-4">${l.municipio.nombre}</div>
							
						</div>
					</a>
					</c:forEach>
					
		</div>
	</div>
	

<!-- Listado formaciones finalizadas -->

	<div class="col-md-12 well oculto" id="listaFin">
		<div class="list-group ">
			<a href="#" class="list-group-item active">Listado de formaciones Finalizadas (Excel)</a>
			<c:forEach items="${listaFinalizados}" var="l">
				<a href="PrepararResumen?idFormacion=${l.id}" class="list-group-item">
					
					<div class="row">
						<div class="col-md-4">${l.nombre}</div>
						<div class="col-md-4">${l.municipio.nombre}</div>
						
					</div>
				</a>
				</c:forEach>
				
		</div>
	</div>


</div>	
</section>



</div>
	<script type="text/javascript" src="resources/js/listados.js"></script>

	<script src="resources/js/bootstrap.min.js"></script>
<!-- __________________FOOTER___________________-->

<!--Logo del equipo , y nombre y linkedin de cada uno// Distribucion de bootstrap 2-1-3-3-3-->


<footer id="footer" style="width: 100%;height: 20%;margin-top: 2em;">

<div class="container-fluid">

	<div class="row">
	
		<div class="col-md-3" align="center" >
		
			<img id="logo izquierda" src="resources/img/LogoEquipo.png" style="width:100%; height:100%;">
			<a>EQUIPO JAVA TOLETVM</a>
		</div>

		<div class="col-md-3" align="center" style="margin-top: 7em;">	
			
				<a href="https://www.linkedin.com/in/josedelcastillomartínez/" target="_blank">Jose del Castillo Martinez de la Casa </a>
				
				<br>
				<a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Ben�tez</a>
			
				
				
			</div>
		<div class="col-md-3" align="center" style="margin-top: 7em;">
			
				<a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig	</a>
				<br>

				<a href="https://www.linkedin.com/in/vicentenavarrogarcia/" target="_blank">Vicente Navarro Garcia</a>
				
				<br>
				<a href="https://www.linkedin.com/in/eduardo-redondo/" target="_blank">Eduardo Redondo Pérez</a>
			
			
				
		</div>
		
		<div class="col-md-3" align="center" style="margin-top: 7em;">
			
				<a href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara Sanabria Pérez</a>
				<br>
				<a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta Garcia</a>
				
		</div>

		</div>

	</div>

</footer>

<!-- _____________________________ FIN FOOTER __________________________________ -->
</body>
</html>