jQuery(document).ready(function() {

	var contextPath = "<%=request.getContextPath() %>";
	
    $('#comunidad').change( function(e) {
        var comunidad=document.getElementById("comunidad");
        if(comunidad.value!="0"){        	
        	var provincia=document.getElementById("provincia");
        	var municipio = document.getElementById("municipio");
        while(provincia.length>0){
            provincia.remove(0);
        }
        while(municipio.length>0){
        	municipio.remove(0);
        }
        var o=document.createElement("OPTION");
        o.value="0";
        o.text="Seleccione una Provincia";
        provincia.add(o);
        o.value="0";
        o.text="Seleccione una Localidad";
        municipio.add(o);
        jQuery("#provincia").removeAttr("disabled");
        
        	
            //$('#othstate').val('').hide();
            $.ajax({
               url: "listaProvincias?idComunidad="+comunidad.value,
               dataType: 'json',
             
               success: function(result) {
	               var s="";
	               var provincia=document.getElementById("provincia");
	               var i;
	               var o=document.createElement("OPTION");
              		o.value=0;
              		o.text="Seleccione provincia";
              		provincia.add(o);
	               for(i=0;i<result.length;i++){
	            	   
	               		o=document.createElement("OPTION");
	               		o.value=result[i].id;
	               		o.text=result[i].provincia;
	               		provincia.add(o);
	               }
               },
               error:
               function(e){
             alert('Error: ' + e);
             } 
            });
        }
        else {
           $("#provincia").attr("disabled","disabled");
           $("#municipio").attr("disabled","disabled");
        
        }
    });

    function showUsers(data) {
 
        for ( var i = 0, len = data.length; i < len; ++i) {
            var msajax = data[i];
            $('#comunidad').append("<option value=\"" +msajax.idprovincia + "\">" + msajax.provincia+ "</option>");
        }
    }

});