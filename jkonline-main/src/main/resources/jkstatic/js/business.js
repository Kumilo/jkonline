$(document).ready(function(){
	
	$("#myModal").on("hidden.bs.modal", function() {  
	    $(this).removeData("bs.modal");  
	}); 

	$("#submitAddXuyuan").click(function(){
		
		var data = $("#addXueyuanForm").serialize();
		
		$.ajax({
		  type: 'POST',
		  url: '/jk/add',
		  data: data,
		  success: function(data){
			  clearForm();
			  alert(data);
		  },
		  error: function (){}
		 
		});
	});
	
	
	$("#updateAddXuyuan").click(function(){
		
		var data = $("#updateXueyuanForm").serialize();
		$.ajax({
		  type: 'POST',
		  url: '/jk/update',
		  data: data,
		  success: function(data){
			  clearForm();
			  $("#tips").html(data);
		  },
		  error: function (){}
		 
		});
	});
	
	
})

function clearForm(){
	
	 $("#memo").val("");
	 $("#age").val("");
	 $("#name").val("");
	 $("#cert").val("");
	 $("#phone").val("");
}


