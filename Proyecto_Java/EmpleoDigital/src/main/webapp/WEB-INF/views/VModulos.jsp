<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>

<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Crear un nuevo curso</title>

<meta   name="keyword" content="Proyecto, telefÃ³nica fundaciÃ³n , empleo digital "     >

  <meta name="description" content="Proyecto Final">


  <meta name="distribution" content="global">

  <meta name="Robots" content="all">

  <meta name="author" content="Java Toletvm">

  <meta name="email" content="javatoletvm@gmail.com">

  <meta name="viewport" content="width=device-with,intital-scale=1.0">
  
  
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
      <link rel="stylesheet" href="resources/css/styleArrastrarModulo.css">
      <link rel="stylesheet" href="resources/css/styleDatepicker.css">
      <link rel="stylesheet" href="resources/css/jquery-ui.min.css" />
<style type="text/css">
	.desplegable{
 	border: 1px solid #ccc;
}

</style>     
		<script>
				$(function () {
				$("#datepicker").datepicker();
				});
			</script>
  
</head>

<body>
<form action="VCInsertarVacaciones" method="POST">

<input type="hidden" name="idFormacion" value="${idFormacion}">

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



      <br></br>

  <div class="container-fluid pad" >
  <div class="col-xs-3 header">
    Módulos Troncales
  </div>
  <div class="col-xs-3 header">
    H.Personales
  </div>
   <div class="col-xs-3 header">
    Módulos EspecÃ­ficos
  </div>
 
  <div class="col-xs-3 header">
    
   	<div class="button_div">
     <input type="submit" value="Generar nuevo curso" class="buttons" />
      </div>	
   </div>
  </div>
  
</div>








<!-- COLUMNA DE LOS MÓDULOS DEL BLOQUE TRONCAL -->


  <div class="col-xs-3 drag-1 bg" id="1">
  
      <c:set var="posicion" value="1"/>
  
          <c:forEach items="${listaTroncal}" var="troncal">
                  <div class="box" id="caja_1_${troncal.id}"> 
                     <input type="hidden" id="modulo_${troncal.id}" name="modulo_${troncal.id}"  value="0">
                      <div class='tasks'>
                        <div class="desplegable">
                            <div class="titulo">
                              <span class='task-name'>${troncal.nombre}</span>
                            </div>
                            <div class="contenido">
                            <br/>
                              <span class='task-desc'>Troncal</span>
                            <br/>
                              <span class='task-hor'>${troncal.horas} </span> Horas
                            <br/>
                              <span class='task-jor'>${troncal.jornadas}</span> Jornadas
                            <br/>
                    					 <div id="fecha_${troncal.id}" style="display:none;">
                             				<label for="fechaModulo_${troncal.id}">Fecha:</label>
                    					  <input type="text" name="fechaModulo_${troncal.id}" id="fechaModulo_${troncal.id}" />
                               </div>
                            </div>
                        </div>
                        <c:set var="posicion" value = "${posicion + 1}"/>
                      </div>   
                  </div>
            </c:forEach>
  </div>





<!-- COLUMNA DE LOS MÓDULOS DEL BLOQUE HABILIDADES PERSONALES -->


    <div class="col-xs-3 drag-2 bg" id="2">
  
      <c:set var="posicion" value="1"/>
  
          <c:forEach items="${listaSuma}" var="suma">
                  <div class="box" id="caja_2_${suma.id}"> 
                     <input type="hidden" id="modulo_${suma.id}" name="modulo_${suma.id}"  value="0">
                      <div class='tasks'>
                        <div class="desplegable">
                            <div class="titulo">
                              <span class='task-name'>${suma.nombre}</span>
                            </div>
                            <div class="contenido">
                            <br/>
                              <span class='task-desc'>H.Personales</span>
                            <br/>
                              <span class='task-hor'>${suma.horas} </span> Horas
                            <br/>
                              <span class='task-jor'>${suma.jornadas}</span> Jornadas
                            <br/>
                               <div id="fecha_${suma.id}" style="display:none;">
                             	<label for="fechaModulo_${suma.id}">Fecha:</label>                               
                                 <input type="text" name="fechaModulo_${suma.id}" id="fechaModulo_${suma.id}"/>
                               </div>
                            </div>
                        </div>
                        <c:set var="posicion" value = "${posicion + 1}"/>
                      </div>   
                  </div>
            </c:forEach>
  </div>








    <!-- COLUMNA DE LOS MÓDULOS DEL BLOQUE METODOLOGÍAS --> 


      <div class="col-xs-3 drag-3 bg" id="3">
  
      <c:set var="posicion" value="1"/>
  
          <c:forEach items="${listaMetodo}" var="metodo">
                  <div class="box" id="caja_3_${metodo.id}"> 
                     <input type="hidden" id="modulo_${metodo.id}" name="modulo_${metodo.id}"  value="0">
                      <div class='tasks'>
                        <div class="desplegable">
                            <div class="titulo">
                              <span class='task-name'>${metodo.nombre}</span>
                            </div>
                            <div class="contenido">
                            <br/>
                              <span class='task-desc'>Especifico</span>
                            <br/>
                              <span class='task-hor'>${metodo.horas} </span> Horas
                            <br/>
                              <span class='task-jor'>${metodo.jornadas}</span> Jornadas
                            <br/>
                             
                               	<div id="fecha_${metodo.id}" style="display:none;">
                               	<label for="fechaModulo_${metodo.id}">Fecha:</label>
                                 <input type="text" name="fechaModulo_${metodo.id}" id="fechaModulo_${metodo.id}" />
                                
                               </div>
                            </div>
                        </div>
                        <c:set var="posicion" value = "${posicion + 1}"/>
                      </div>   
                  </div>
            </c:forEach>
        </div>

  











<!-- COLUMNA DE LOS MODULOS SELECCIONADOS PARA NUESTRA FORMACION -->



  <div class="col-xs-3 drag-5 bg" id="5" background_color="#FAAC58">


    
  </div>

  





  
</div>






  
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/45226/dragula.min.js'></script>

    <script src="resources/js/indexArrastrarModulos.js"></script>
   <script type="text/javascript" src="resources/js/jquery-ui.multidatespicker.js"></script>
   <script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
   <script src="resources/js/calendarioDatepicker.js"></script>
   <script src="resources/js/jquery-ui.min.js"></script>
   <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>



<footer id="footer" style="width: 100%;height: 20%;margin-top: 2em;">

<div class="container-fluid">

  <div class="row">
  
    <div class="col-md-4" align="center" >
    
      <img id="logo izquierda" src="resources/img/LogoEquipo.png" style="width:100%; height:100%;">
      <a>EQUIPO JAVA TOLETVM</a>
    </div>

    <div class="col-md-4" align="center" style="margin-top: 7em;">  
      
        <a href="https://www.linkedin.com/in/josedelcastillomartÃ­nez/" target="_blank">Jose del Castillo Martinez de la Casa </a>
        
        <br>
        <a href="https://www.linkedin.com/in/vanesagallardobenitez/" target="_blank">Vanesa Gallardo Benítez</a>
      
        
        
      </div>
    <div class="col-md-4" align="center" style="margin-top: 7em;">
      
        <a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig  </a>
        <br>

        <a href="https://www.linkedin.com/in/vicentenavarrogarcia/" target="_blank">Vicente Navarro Garcia</a>
        
        <br>
        <a href="https://www.linkedin.com/in/eduardo-redondo/" target="_blank">Eduardo Redondo PÃ©rez</a>
      
      
        
    </div>
    
    <div class="col-md-4" align="center" style="margin-top: 7em;">
      
        <a href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara Sanabria PÃ©rez</a>
        <br>
        <a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta Garcia</a>
        
    </div>

    </div>

  </div>





</footer>    

</form>
</body>
</html>
