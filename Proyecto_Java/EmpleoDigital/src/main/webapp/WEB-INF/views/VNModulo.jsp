<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<title>Modal Nuevo modulo</title>
	<meta charset="UTF-8">
	<meta name="description" content="Plataforma organizativa de cursos formativos"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="distribution" content="global">
	<meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
	<meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
	<meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>


  <!-- link con el fichero de Bootstrap-->
	<link rel="stylesheet prefech" type="text/css" href="resources/css/bootstrap.min.css">
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
<!--Bootstrap 6-6 // Color corporativo de fondo-->
<section style=" background-color: #8DC6CD; width: 100%; height: 60%;">
	
	<div class="row">

		<div class="col-md-6">
			
			<img src="resources/img/Fondo.png" style="height:100%;">

		</div>

		<div class="col-md-6">

				
			
		</div>	


	</div>
	

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
			<a>GRUPO JAVA TOLETVM</a>

		</div>

		<div class="col-md-3" align="center">	
			<br>
			<br>
				<a href="https://www.linkedin.com/in/josedelcastillomartÃ­nez/" target="_blank">Jose del Castillo Martinez de la Casa </a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Benítez</a>
			
		</div>
		<div class="col-md-3" align="center">
			
			<br>
			<a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig	</a>
			<br>
			<br>
				<a href="https://www.linkedin.com/in/vicentenavarrogarcia/" target="_blank">Vicente Navarro García</a>
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

		



</footer>

	<div class="container">
		

		<!-- Velo = fade-->
		<div class="modal fade" id="ventanaNM" style="top:30%;">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Cabecera de la modal-->
					<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" onclick="location.href='VCBotonCrearModificar'" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Crear Nuevo Modulo</h4>
					</div>
					
					<!-- Contenido de la modal, que serÃ¡ el formulario de crear modulo-->
					<div class="modal-body">
						<form action="nuevoModulo" class="form-horizontal" role="form" method="post">
							<div class="form-group">
								<label for="lMNombre" class="col-lg-2 control-label">Nombre del Modulo:</label>
								<div class="col-lg-10">
									<input name="nombre" type="text" class="form-control" id="iMNombre" placeholder="Nombre del modulo aqui">
								</div>
							</div>
							<div class="form-group">
								<label for="lMBloque" class="col-lg-2 control-label">Bloque:</label>
								<div class="col-lg-10">
									<select name="b" type="text" class="textbox" id="bloqueS" >
										<option value = "-1">-- Eligue una opción --</option>
										 <option value="0">Troncal</option>
										<option value="1">Específicos</option>
										<option value="2">Habilidades Personales</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="lMHoras" class="col-lg-2 control-label">Horas:</label>
								<div class="col-lg-10">
									<input name="horas" type="number" class="form-control" id="iMHoras" placeholder="Duracion en horas aqui" value="${modulo.horas}">
								</div>
							</div>
							<div class="form-group">
								<label for="lMJornadas" class="col-lg-2 control-label">Jornadas:</label>
								<div class="col-lg-10">
									<input name="jornadas" type="number" class="form-control" id="iMJornadas" placeholder="Duracion en jornadas aqui">
								</div>
							</div>
								<label class="checkbox-inline">
								<input type="checkbox" value="true" name="tutoria">Tiene tutoria</label> 
							</div>
							<!-- Footer, donde estan lo botones de guardar modulo y salir -->
							<div class="modal-footer">
								<button type="reset" class="btn btn-default">Borrar</button>
								<button type="submit" class="btn btn-primary">Guardar modulo</button>
								
							</form>	
								</div>
									<button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCIndex'">Salir</button>
								</div>
							</div>
						
						
			</div>
		</div>

	
  <!--script de jQuery -->
	<script src="resources/js/jquery.min.js"></script>
  <!-- script de bootstrap-->
  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
  <!-- script que hace que aparezca la modal al cargar la pÃ¡gina -->
  <script type="text/javascript">
    $(window).load(function(){
        $('#ventanaNM').modal('show');
    });
</script>
</body>
</html>
