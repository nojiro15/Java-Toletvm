
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html lang="en">
<head>
  <title>¿Que hacer?</title>
  <meta charset="UTF-8">
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
<!--Bootstrap 6-6 // Color corporativo de fondo-->
<section style=" background-color: #8DC6CD; width: 100%; height: 60%;">
  
  <div class="row">

    <div class="col-md-6">
      
      <img src="resources/img/Fondo.png" style="height:100%;">

    </div>

    <div class="col-md-6">

        
      
      </div>  


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
      <a href="https://www.linkedin.com/in/noemijimenezroig/" target="_blank">Noemi Jimenez Roig  </a>
      <br>
      <br>
        <a href="https://www.linkedin.com/in/vicentenavarrogarcia/" target="_blank">Vicente Navarro Garcia</a>
      <br>
      <br>
        <a href="https://www.linkedin.com/in/eduardo-redondo/" target="_blank">Eduardo Redondo PÃ©rez</a>
    
      
    </div>
    
    <div class="col-md-3" align="center">
      <br>
      <br>
        <a href="https://www.linkedin.com/in/sara-sanabria/" target="_blank">Sara Sanabria PÃ©rez</a>
      <br>
      <br>
        <a href="https://www.linkedin.com/in/mariouceta/" target="_blank">Mario Uceta Garcia</a>
    </div>

    </div>

  </div>
</div>
    



</footer>
<div class="container">


  <!-- Modal -->
  <div class="modal fade" id="modalCrear" role="dialog" style="top:30%;">
    <div class="modal-dialog">
    
      <!-- Modal content-->
    <div align=center>
      <div class="modal-content">
        <div class="modal-header">
         <button type="button" class="close" data-dismiss="modal" onclick="location.href='VCIndex'">&times;</button>
          <h4 class="modal-title">¿Qué deseas crear?</h4>
        </div>
        <div>
          
        </div>
        <div class="modal-body">
           
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCCrearNFormacion'">Nueva formacion</button>
            
            
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCCrearNModulo'">Nuevo Modulo</button><br>
            
            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.href='VCCrearFestivos'">Añadir Festivos</button>
        </div>
     </div>   
      </div>
      
    </div>
  </div>
  
</div>
	<script src="resources/js/jquery.min.js"></script>
  <!-- script de bootstrap-->
  <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
  <script type="text/javascript">
    $(window).load(function(){
        $('#modalCrear').modal('show');
    });
</script>
</body>
</html>
