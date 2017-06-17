<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="es">
<head>
	<title>Vista de Festivos</title>
	<meta charset="UTF-8">
	<meta name="description" content="Plataforma organizativa de cursos formativos"/>
	<meta name="distribution" content="global">
	<meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
	<meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
	<meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>
	<link rel="stylesheet" type="text/css" href="resources/css/VFestivos.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	 <!--script de jQuery -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<!-- script para el calendario -->
	<link rel="stylesheet" href="resources/css/jquery-ui.min.css" />
	<script src="resources/js/jquery-ui.js"></script>
	<script src="resources/js/CalendarioFestivos.js"></script>
	
	<script>
		$(function () {
		$("#datepicker").datepicker();
		});
	</script>
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
<form action="altaFiestas" method="post">
	<!-- Tipo de Festivos -->
	<div class="row" id="tipoFestivo">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 inf" >
		
			
					<div class="form-group">
					  <label for="tipoFest">Tipo de festivo:</label>
					  <select class="form-control" id="tipoFest" name="tipoFiesta">
					    <option>--Seleccione una opci�n--</option>
					    <option value="0">Nacional</option>
					    <option value="1">Regional</option>
					    <option value="2">Local</option>
					   
					  </select>
					</div> 
		
		</div>
		<div class="col-sm-3">
		</div>


	</div>

	<!-- Regiones solo aparecerá si en tipo se selecciona Reginal -->
	<div class="row" id="regiones">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 inf" >
		
			
					<div class="form-group">
					  <label for="region">Comunidad:</label>
					  <select class="form-control" id="comunidad" name="idComunidad">
					  	<option value="0">Seleccionar Comunidad</option>
					  	<c:forEach items="${listaComunidades}" var="com">
					  		<option value="${com.id}"/>${com.comunidad}</option>
					  	</c:forEach>
					  </select>
					</div> 
		
		</div>
		<div class="col-sm-3">
		</div>
	</div>
	
		<!-- Select de provincia -->
	<div class="row" id="contenedor_provincia">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 inf" >
		
			
					<div class="form-group">
					  <label for="provincia">Provincias:</label>
					  <select class="form-control" id="provincia" name="idProvincia" disabled="disabled">
					  	<option value="0">.....</option>
					  </select>
					</div> 
		
		</div>
		<div class="col-sm-3">
		</div>
	</div>

	<!-- Localidad sólo aparecerá si en tipo se indica local -->
	<div class="row" id="localidades">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 inf">
		
			
					<div class="form-group">
					  <label for="localidad">Localidad:</label>
					   <select class="form-control" id="municipio" name="municipio" disabled="disabled">
	    				<option value="-1">--Selecciona Localidad--</option>
					    
					   
					  </select>
					</div> 
		
		</div>
		<div class="col-sm-3">
		</div>
	</div>

	<!-- Nombre de la festividad -->
		<div class="row" id="nombreFestivo">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6 inf">

					<div class="form-group">
					  <label for="localidad">Nombre del Festivo:</label>
					  <input type="text" class="form-control" name="nombre"/>
					</div> 
		
		</div>
		<div class="col-sm-3">
		</div>
	</div>

	<!-- Calendario para checkear los festivos -->

	   <div class="row" id="calendarioFestivos">
	   	<div class="col-sm-3">
		</div>
        <div class="col-sm-6 planner">
           <div class="calendarioFest">
           	<label for="fecha">Fecha:</label>
           	<input type="text" id="datepicker" name="fecha">
           	<script>$("#datepicker").datepicker({dateFormat:"dd/mm/yy",constraintInput:true});</script> 
           	
           </div>
          </div>
        <div class="col-sm-3">
		</div>

    </div>
    <div class="row" id="botoneraFest">
    	<div class="col-sm-3">
		</div>
		<div class="col-sm-6" align="right">
		
    	<button type="reset" class="btn btn-default">Borrar formulario</button>
		<button type="submit" class="btn btn-primary">Guardar festivo</button>
		<button type="button" class="btn btn-primary" onclick="location.href='ListarFestivos'">Listar Festivos</button>
		<button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCBotonCrearModificar'">Salir</button>
		
		</div>
		<div class="col-sm-3">
		</div>
	</div>
	
<script type="text/javascript" src = "resources/js/municipioAjax.js" ></script> 
<script type="text/javascript" src = "resources/js/provinciaAjax.js" ></script> 
	
	
	
	
	
	
	<!-- __________________FOOTER___________________-->
	
	<!-- script de bootstrap-->
  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</form>
	
</section>
	
  
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
</div>
		



</footer>
	

</body>

</html>"