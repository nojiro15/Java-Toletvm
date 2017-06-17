<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Plataforma organizativa de cursos formativos</title>
  <meta charset="UTF-8">
  <meta name="description" content="Plataforma organizativa de cursos formativos"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="distribution" content="global">
  <meta name="keywords" content="Talentum empleo, Empleo digital, Formacion, Fundacion telefonica, java, toledo"/>
  <meta name="author" content="Eduardo Redondo Perez, Jose del Castillo Martinez de la Casa, Sara Sanabria Perez, Vicente Navarro Garcia, 
  Noemi Jimenez Roig, Vanesa Gallardo Jimenez, Mario Uceta Garcia" />
  <meta name="email" content="redondo.perez.eduardo@gmail.com, jmartzcas@gmail.com, v_gallardo_b@hotmail.com,
  mario_uce_gar@outlook.com,navarromembrilla@yahoo.es,noemi.jimenez.roig@gmail.com, ssanabria@gmail.com"/>
  
  <link rel="stylesheet" type="text/css" href="resources/css/styleResumen.css">
  <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

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










<body>

<div id="dvData">

<table class="responstable" id="tblReporte">
  
  <tr>
    <th colspan="4">Resumen Nueva Formación</th>
  </tr>
  
  <tr>
    <td class="sub" colspan="2">Nombre del curso</td>
    <td colspan="2">${formacion.nombre}</td>   
  </tr>
  
  <tr>
    <td class="sub"  colspan="2">Provincia</td>
    <td>${provincia.provincia}</td>
  </tr>
  
  <tr>
    <td class="sub"  colspan="2">Localidad</td>
    <td>${localidad.municipio}</td>
  </tr>
  
  <tr>
    <td class="sub"  colspan="2">Fecha de inicio</td>
    <td  colspan="2">${stFechaInicio}</td>
  </tr>
   <tr>
    <td class="sub"  colspan="2">Fecha de Fin</td>
    <td  colspan="2">${stFechaFin}</td>
  </tr>
  <tr>
    <td class="sub"  colspan="2">Jornadas Totales</td>
    <td  colspan="2">${jornadasTotales}</td>
  </tr>
  

</table>


	</br>
<table class="responstable" id="tblReporte2">
  
  <tr>
    <th colspan="4">Módulos incluidos en la Formación</th>
  </tr>
  <tr class="sub">
    <td>NOMBRE</td>
    <td>JORNADAS</td>
    <td>HORAS</td>
    <td>HORAS DE TUTORÍA</td>
  </tr>
  <c:forEach items="${listaModulos}" var="m">
  <tr class="sub">
    <td>${m.nombre}</td>
    <td>${m.jornadas}</td>
    <td>${m.horas}</td>
    <td>${m.horasTutorias}</td>
  </tr>

 </c:forEach> 
</table>

</div>

<br>

<input type="button" id="btnExport" value=" Exportar a Excel " />
 
    <script>
    $("#btnExport").click(function(e) {
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#dvData').html()));
        e.preventDefault();
    });
    </script>

 
    <input type='button' onclick='window.print();' value='Imprimir/Exportar a PDF' />
  	<input type='button' onclick='window.location="modForm?idFormacion=${formacion.id}";' value="Modificar Formación"/>
<button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCIndex'">Salir</button>








<br>
<br>
<br>
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
        <a href="https://www.linkedin.com/in/josedelcastillomartÃ­nez/" target="_blank">Jose del Castillo Martínez de la Casa </a>
      <br>
      <br>
        <a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Benítez</a>
      
      </div>
    <div class="col-md-3" align="center">
      
      <br>
      <a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig  </a>
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
        <a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta García</a>
    </div>

    </div>

  </div>
</div>
    

<br>
<br>

</footer>

	
  
</body>
</html>