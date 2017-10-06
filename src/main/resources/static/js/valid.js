/**
 * 
 */
$(document).ready(function(){
	$(".valid").click(function(){
		validar(this.id,this)
		
	});
	
	$(".valid-all").click(function(){
		$.each($(".valid"),function(i,o){
			validar(o.id,o)
			
		})
		
	})
	
	function validar(uri,div) {

		$.ajax({
			url : "/process",
			data : {
				url:uri
			},
			method : "post",
			success : function(data, status) {
				$(div).addClass(data ? "btn-danger":"btn-success");
			},
			error : function(error) {
				alert("error url: "+ uri);

			}

		});

	}
	
})
