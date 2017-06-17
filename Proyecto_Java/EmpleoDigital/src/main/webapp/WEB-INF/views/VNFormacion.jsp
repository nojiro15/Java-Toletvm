<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Nueva Formación</title>
  
  
  
      <link rel="stylesheet" href="resources/css/styleNF2.css">
      <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  	   <link rel="stylesheet" href="resources/css/styleDatepicker.css">
  	   <link rel="stylesheet" href="resources/css/jquery-ui.min.css" />
  	    <script type="text/javascript" src = "resources/js/jquery-3.2.1.min.js"></script>
  	  
</head>

<body>



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











  
  <div id="container" style="background-color: #8dc6cd">
	  
	  <div id="caja">
	  
		<hr size="1">
	  	
				<legend>Nuevo Curso</legend>
	
	
						<!-- Empieza formulario -->
	
	
	
							<form  method="POST" class="form" action="VCInsertModulosFormacion">

								<div class="row">

										<fieldset>
											<div class="col-md-6">
							    				<label for="nombre">Nombre del curso</label>
							    			</div>
							    			<div class="col-md-6">
													<div class="div_texbox">
												    <input name="nombre" type="text" class="textbox" id="nombre" placeholder="Nombre" />
													</div>
											</div>
										</fieldset>
										

										<fieldset>
											<div class="col-md-6">
													<label for="provincia">Provincia</label>
											</div>

											<div class="col-md-6">
												<div class="div_texbox">
												     <select name="provincia" type="text" class="textbox" id="provincia"/>
										    				<option value="0">Seleccione una Provincia</option>
										    				<c:forEach items="${listaProvincias}" var="pro">
															  	<option value="<c:out value="${pro.id}"/>">
															  	<c:out value="${pro.provincia}"></c:out>
															  	</option>
														  	</c:forEach>
													</select>				
													
												</div>
											</div>
										</fieldset>
										<fieldset>
											<div class="col-md-6">
													<label for="Localidad">Localidad</label>
											</div>

											<div class="col-md-6">
												<div class="div_texbox">
													    <div class="form-group">
													     	<select class="form-control" id="municipio" name="municipio" disabled="disabled">
									    					<option value="-1">--Selecciona Localidad--</option>
								
													 		</select>
													</div>			
												</div>
											</div>
										</fieldset>
										<fieldset>
											<div class="col-md-6">
													<label for="fechaInicio">Fecha de inicio</label>
											</div>

											<div class="col-md-6">
												<div class="div_texbox">
											    		<input name="fechaInicio" type="text" class="textbox" id="fechaInicio" />
											    			
												</div>
												<div class="button_div">
												 <input name="Continuar" type="submit" class="buttons" />
												</div>
											</div>
										</fieldset>
								</div>
							</form>	

		</div>
	</div>
	
	<div class="clear"></div>
	
	<script type="text/javascript" src = "resources/js/municipioAjax.js" ></script>  
	<script type="text/javascript" src="resources/js/jquery-ui.multidatespicker.js"></script>
	 <script src="resources/js/calendarioDatepicker.js"></script>
	 <script src="resources/js/jquery-ui.min.js"></script>
	  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	 <script>
		$(function(){ 
		$("#fechaInicio").datepicker({dateFormat: "dd/mm/yy",constrainInput:true});
		});
	</script>
	



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
				<a href="https://www.linkedin.com/in/eduardo-redondo/" target="_blank">Eduardo Redondo PÃ©rez</a>
			
			
				
		</div>
		
		<div class="col-md-3" align="center" style="margin-top: 7em;">
			
				<a href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara Sanabria PÃ©rez</a>
				<br>
				<a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta Garcia</a>
				
		</div>

		</div>

	</div>

		



</footer>
	
  
</body>
</html>
