/* Javascript para hacer aparecer o desaparecer los listados */

jQuery(document).ready(function(){
	$(".oculto").hide();
		$(".inf").click(function(){
			var nodo = $(this).attr("href");

			if($(nodo).is(":visible")){
				$(nodo).hide();
				return false;
			}else{
				$(".oculto").hide("slow");
				$(nodo).fadeToggle("fast");
				return false;
			}
		})
})
/*
$(document).ready(function(){
	$(".hidden").hide();
		$(".inf").click(function(){
			var nodo = $(this).attr("href");

			if($(nodo).is(".show")){
				$(nodo).hide();
				return false;
			}else{
				$(".hidden").hide("slow");
				$(nodo).fadeToggle("fast");
				return false;
			}
		})
})*/

/*
$(document).ready(function(){
	$(".inf").on("click",function(){
		var nodo = $(this).attr("href");

		if($(nodo).show()){
			$(nodo).hide();
		}else{
			$(nodo).show();
		}
	})
})*/