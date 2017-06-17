<!DOCTYPE html>
<html>
<html>
<head>
<meta charset="UTF-8">
<title>Vacaciones</title>
<meta name="description"
	content="Plataforma organizativa de cursos formativos" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="distribution" content="global">
<meta name="keywords"
	content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo" />
<meta name="author"
	content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
	Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
<meta name="email"
	content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
	mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com" />
	<!-- Recursos-->
	<link rel="stylesheet" type="text/css" href="resources/css/styleVVacaciones.css">
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	 <!--script de jQuery -->
	<script src="resources/js/jquery-3.2.1.min.js"></script>
	<!-- script para el calendario -->
	<link rel="stylesheet" href="resources/css/jquery-ui.min.css" />
	<script src="resources/js/jquery-1.9.1.js"></script>
	<script src="resources/js/jquery-ui.multidatespicker.js"></script>
	<script src="resources/js/CalendarioFestivos.js"></script>
	<script src="resources/js/jquery-ui.js"></script>
	<script>
		$(function () {
		$("#datepicker").datepicker();
		});
	</script>


</head>
<body>
	<!-- Cabecera con bootstrap 3.3.7 , distribucion 4, 4, 4, // Logos corporativos-->

	<header id="header" class="Cabecera">

		<div class="container-fluid">

			<div class="row">
				<div class="col-md-4">

					<img id="logo izquierda" src="resources/img/empleo.png">

				</div>

				<div class="col-md-4">

					<h1 align="center">Plataforma de formaciones</h1>

				</div>

				<div class="col-md-4">

					<img id="logo derecha" src="resources/img/fundacion.png"
						align="right">

				</div>

			</div>


		</div>

	</header>
	<!--Bootstrap 6-6 // Color corporativo de fondo-->
	<section style="background-color: #8DC6CD; width: 100%; height: 60%;">

		<div class="row">

			<div class="col-md-6">

				<img src="resources/img/Fondo.png" style="height: 100%;">

			</div>

			<div class="col-md-6"></div>


		</div>

	</section>
	<!--Logo del equipo , y nombre y linkedin de cada uno// Distribucion de bootstrap 2-1-3-3-3-->

	<footer id="footer" class="pie">

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">

					<img id="logo izquierda" src="resources/img/LogoEquipo.png"
						width=100%; height=100%>

				</div>

				<div class="col-md-1">
					<br> <br> <a>EQUIPO JAVA TOLETVM</a>

				</div>

				<div class="col-md-3" align="center">
					<br> <br> <a
						href="https://www.linkedin.com/in/josedelcastillomartÃ­nez/"
						target="_blank">Jose del Castillo Martínez de la Casa </a> <br>
					<br> <a
						href="https://www.linkedin.com/in/vanesagallardobenitez/"
						target="_blank">Vanesa Gallardo Benítez</a>

				</div>
				<div class="col-md-3" align="center">

					<br> <a href="https://www.linkedin.com/in/noemijimenezroig/"
						target="_blank">Noemi Jimenez Roig </a> <br> <br> <a
						href="https://www.linkedin.com/in/vicentenavarrogarcia/"
						target="_blank">Vicente Navarro García</a> <br> <br> <a
						href="https://www.linkedin.com/in/eduardo-redondo/"
						target="_blank">Eduardo Redondo Pérez</a>


				</div>

				<div class="col-md-3" align="center">
					<br> <br> <a
						href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara
						Sanabria Pérez</a> <br> <br> <a
						href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario
						Uceta García</a>
				</div>

			</div>

		</div>

	</footer>
	<!-- Modal para las vacaciones -->
	<div class="container">
	
		<!-- Velo -->
		<div class="modal fade" id="modalVacaciones" style="top: 30%;">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Cabecera de la modal -->
					<div class="modal-header">
						<button type="button" class="close" location.href="VCrear" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Añadir Vacaciones</h4>
					</div>
					<!-- Fin cabecera modal -->
					<!-- Contenido de la modal -->
					<div class="modal-body">
						<form action="VCResumen" method="post">
						<input type="hidden" name="idFormacion" value="${idFormacion}">
							<div class="form-group">
							<div class="row" align="center">
								<div class="col-lg-10">
									<label for="asunto">Asunto:</label>
									<input type="text" name="asunto">
								</div>
							</div>
							
							</div>
							<div class="form-group">
								<div class="row" align="center">
									<div class="col-lg-10">
										<div class="calendarioVacaciones" id="vacaciones">
											<label for="fecha">Fecha:</label>
											<input type="text" name="fecha" id="fecha">
											<!-- Datepicker -->
											<script>$("#fecha").multiDatesPicker({dateFormat: "dd/mm/yy",
											constrainInput:true});</script>	
			 								<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>		


										</div>
									</div>
								</div>
								<hr>
								<div class="row"></div>
								<div class="row">
									<div class="col-sm-3">
									
									</div>
									<div class="col-sm-2">
									<button type="submit" class="btn btn-primary">Insertar vacaciones</button>
									
									</div>
									<div class="col-sm-2">

									</div>
									<div clas="col-sm-2">
									<button onclick="location.href='PrepararResumen'" class="btn btn-info">Ir al resumen</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
 
	</div>


 <!-- script que hace que aparezca la modal al cargar la pÃ¡gina -->
  	<script type="text/javascript">
    $(window).load(function(){
        $('#modalVacaciones').modal('show');
    });
</script>
</body>

</html>