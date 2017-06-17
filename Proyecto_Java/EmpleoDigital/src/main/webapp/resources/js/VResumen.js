function descargarExcel(variable_conTabla){
        //Creamos un Elemento Temporal en forma de enlace
        var tmpElemento = document.createElement('a');
        // obtenemos la información desde el div que lo contiene en el html
        
        // Obtenemos la información de la tabla
        var data_type = 'data:application/vnd.ms-excel';
        var tabla_div = variable_conTabla;
        var tabla_html = tabla_div.replace(/ /g, '%20');
        tmpElemento.href = data_type + ', ' + tabla_html;
        //Asignamos el nombre a nuestro EXCEL
        tmpElemento.download = 'Resumen curso.xls';
        // Simulamos el click al elemento creado para descargarlo
        tmpElemento.click();
    }