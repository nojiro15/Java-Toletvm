<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="es">
<head>
	<title>Lista de Festivos</title>
	<meta charset="UTF-8">
	<meta name="description" content="Plataforma organizativa de cursos formativos"/>
	<meta name="distribution" content="global">
	<meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
	<meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
	<meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>
	
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	 <!--script de jQuery -->
	 <script src="resources/js/jquery-3.2.1.min.js"></script>
	 
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">


</head>
<body>

<!-- _______________ HEADER ________________-->

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

<!-- ___________________FIN HEADER__________________-->	

<!-- ___________________SECTION_______________________-->
<!--Bootstrap 6-6 // Color corporativo de fondo-->
<section style=" background-color: #8DC6CD; width: 100%; height: 80%;">

<!-- Listado-->	
	<div class="row " style="margin-top: 6em;">
		<div class="col-md-12 well" id="listado">
			<div class="list-group " >
			<a href="#" class="list-group-item active">Fiestas Nacionales</a>			
			<c:forEach items="${listaN}" var="n">
				<div class="row">
					<div class="col-md-3">
						<c:out value="${n.nombre}"></c:out>
					</div>
					<div class="col-md-3">
						<c:out value="${n.fecha}"></c:out>						
					</div>	
					<div class="col-md-3">
						<button type="button" class="fa fa-pencil"  onclick='window.location="modificarFiestaNacionalForm?intFecha=${n.intFecha}";'></button>
					</div>
					<div class="col-md-3">
						<button type="button" class="fa fa-trash" onclick='window.location="borrarFiestaNacional?intFecha=${n.intFecha}";'></button>	
					</div>					
				</div>
			</c:forEach>
			<a href="#" class="list-group-item active">Fiestas Regionales</a>	
			<c:forEach items="${listaR}" var="r">
				<div class="row">
					<div class="col-md-3">
						<c:out value="${r.nombre}"></c:out>
						</div>
						<div class="col-md-3">
						<c:out value="${r.fecha}"></c:out>						
					</div>	
					<div class="col-md-3">
						<button type="button" class="fa fa-pencil"  onclick='window.location="modificarFiestaRegionalForm?intFecha=${r.intFecha}";'></button>
					</div>
					<div class="col-md-3">
						<button type="button" class="fa fa-trash" onclick='window.location="borrarFiestaRegional?intFecha=${r.intFecha}";'></button>	
					</div>	
				</div>		
			</c:forEach>
			<a href="#" class="list-group-item active">Fiestas Locales</a>								
			
			<c:forEach items="${listaL}" var="l">
				<div class="row">
					<div class="col-md-3">
						<c:out value="${l.nombre}"></c:out>
					</div>
					<div class="col-md-3">
						<c:out value="${l.fecha}"></c:out>						
					</div>
					<div class="col-md-3">
						<button type="button" class="fa fa-pencil"  onclick='window.location="modificarFiestaLocalForm?intFecha=${l.intFecha}";'></button>
					</div>
					<div class="col-md-3">
						<button type="button" class="fa fa-trash" onclick='window.location="borrarFiestaLocal?intFecha=${l.intFecha}";'></button>	
					</div>		
				</div>		
			</c:forEach>
			
	</div>		
</div>	
</div>
<div class="col-md-4">
	<button type="button" onclick='window.location="VCCrearFestivos";'>Volver a Crear Festivos</button>
	<button type="button" onclick='window.location="VCIndex";'>Volver a Principal</button>
</div>
</section>


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
			
				<a href="https://www.linkedin.com/in/josedelcastillomartÃ­nez/" target="_blank">Jose del Castillo Martinez de la Casa </a>
				
				<br>
				<a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Benítez</a>
			
				
				
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