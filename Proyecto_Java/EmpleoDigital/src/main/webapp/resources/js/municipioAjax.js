jQuery(document).ready(function() {

	var contextPath = "<%=request.getContextPath() %>";
	
    $('#provincia').change( function(e) {
        var provincia=document.getElementById("provincia");
        
    if(provincia.value!="0"){
        var municipio=document.getElementById("municipio");
        while(municipio.length>0){
            municipio.remove(0);
        }
        var o=document.createElement("OPTION");
        o.value="-1";
        o.text="Seleccione una localidad";
        municipio.add(o);
        
        jQuery("#municipio").removeAttr("disabled");
        
        
            //$('#othstate').val('').hide();
            $.ajax({
               url: "listaMunicipios?idProvincia="+provincia.value,
               dataType: 'json',
             
               success: function(result) {
	               var s="";
	               var municipio=document.getElementById("municipio");
	               var i;
	               for(i=0;i<result.length;i++){
	               		var o=document.createElement("OPTION");
	               		o.value=result[i].id;
	               		o.text=result[i].municipio;
	               		municipio.add(o);
	               }
               },
               error:
               function(e){
             alert('Error: ' + e);
             } 
            });
        }
        else {
           $("#municipio").attr("disabled","disabled");
        
        }
    });

    function showUsers(data) {
 
        for ( var i = 0, len = data.length; i < len; ++i) {
            var msajax = data[i];
            $('#provincia').append("<option value=\"" +msajax.idmunicipio + "\">" + msajax.municipio+ "</option>");
        }
    }

});