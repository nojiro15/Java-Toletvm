$(document).ready(function(){
  $("div input").click(function(){
  $(this).focus();
  });
  classnames();
  //call dragula
  dragula([
    document.getElementById('1'), 
    document.getElementById('2'), 
    document.getElementById('3'), 
    document.getElementById('4'),
    document.getElementById('5')
  ],
{
   accepts: function (el, target, source, sibling) {
     var stColOrigen=el.id.substr(5,1);
     //window.alert(stColOrigen);
     var stColDestino=target.id;
     //window.alert(stColDestino);
     if(stColDestino=="5"){
       var stId=el.id.substr(7);
       var modulo=document.getElementById("modulo_"+stId);
       document.getElementById("fecha_"+stId).style.display="inline"; 
       modulo.value="1";
      return true;
    }
     else if(stColOrigen==stColDestino){
      var stId=el.id.substr(7);
       var modulo=document.getElementById("modulo_"+stId);
       modulo.value="0";
      return true;
    }
    return false;

  },
   moves: function (el, container) {
    return true;         // elements are always draggable by default
  },
  revertOnSpill: true,
}
  ).on('drop', function (el) {
   classnames();
  });
  

  //static adding of values
  $(".submit").click(function(){
          var getvalue1 = document.getElementById("name"),
           getvalue2 = document.getElementById("desc"),
           getvalue3 = document.getElementById("hor"),
           getvalue4 = document.getElementById("jor") ,
          
           a = getvalue1.value,
           b = getvalue2.value,
           c = getvalue3.value;
           d = getvalue4.value;
           

         $(".drag-1").append("<div class='box box1'><p class='tasks'><input type='checkbox' class='checkbox checkbox1' name='' value=''/><span class='task-name'>"+a+"</span><br/><span class='task-desc'>"+b+"</span><br/><span class='task-hor'>"+c+"</span><br/><span class='task-jor'>"+d+"</span><br/></div>");

  });

 

  //add selected to done
  $(".toDo").click(function(){
    $(".drag-4 .checked")
      .appendTo(".drag-5");
    $(".drag-5 .checked").removeClass("checked");
    $(".checkbox4").prop("checked", false);
    $(".checkbox4").addClass("checkbox5");
    $(".checkbox4").removeClass("checkbox4 checkbox1 checkbox2 checkbox3");
  });
});

//function for changing names of tasks depending on column
var classnames = function(){
$(".drag-1").children($(".box")).addClass("box1").removeClass("box2 box3 box4 box5");
  $(".drag-2").children($(".box")).addClass("box2").removeClass("box1 box3 box4 box5");
  $(".drag-3").children($(".box")).addClass("box3").removeClass("box1 box2 box4 box5");
  $(".drag-4").children($(".box")).addClass("box4").removeClass("box1 box2 box3 box5");
  $(".drag-5").children($(".box")).addClass("box5").removeClass("box1 box2 box3 box4");
  
}
function prepararSubida(){
	  var columna4=document.getElementById("5");
	  var hijos=columna4.children;
	  var p=0;
	  for(i in hijos){
	    var e=hijos[i];
	    var existeId=typeof(e.id)!=="undefined";
	    if(existeId && e.id.substr(0,5)=="caja_"){
	    var stId=e.id.substr(7);
	        var pos=document.getElementById("modulo_pos_"+stId);
	        pos.value=p;
	        p++;
	     }
	  }
	}
