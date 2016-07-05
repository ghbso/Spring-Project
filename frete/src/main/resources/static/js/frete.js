$(function() {
	$('[rel="tooltip"]').tooltip();

	$('.js-currency').maskMoney({
		//prefix:'R$ ',
		precision: 2,
		decimal : ',',
		thousands : '.',
		allowZero : true
	});

	$('.js-weight').maskMoney({
		//prefix:'(Kg) ',
		precision: 0,
		decimal : ',',
		thousands : '.',
		allowZero : true
	});

	
	function updateValorFrete(event) {
		var codigo = document.getElementById("cidade").value;
		var pesoTotal = document.getElementById("peso").value;
		var txtValorTotal = document.getElementById("valorTotal");
		var parametro = "codigo="+codigo+"&pesoTotal="+pesoTotal;
		
		$.ajax({
			url : "/frete",
			type: 'PUT',	
			data : parametro ,
			success: function(data){
//				alert(data);
				txtValorTotal.value= data;
				txtValorTotal.focus();
			},
			
			error: function(xhr, textStatus, error){
				txtValorTotal.value="0,00";
				txtValorTotal.focus();
				
			},
			
		});

	}
	$('.js-selectOptCidade').change(function(event) {
		var codigo = document.getElementById("cidade").value;
		var pesoTotal = document.getElementById("peso").value;
		var txtValorTotal = document.getElementById("valorTotal");
		var parametro = "codigo="+codigo+"&pesoTotal="+pesoTotal;
		
		$.ajax({
			url : "/frete",
			type: 'PUT',	
			data : parametro ,
			success: function(data){
//				alert(data);
				txtValorTotal.value= data;
				txtValorTotal.focus();
			},
			
			error: function(xhr, textStatus, error){
				txtValorTotal.value="0,00";
				txtValorTotal.focus();
				
			},
			
		});
		
	});

	$('.js-pesoTotal').change(function(event) {
		var codigo = document.getElementById("cidade").value;
		var pesoTotal = document.getElementById("peso").value;
		var txtValorTotal = document.getElementById("valorTotal");
		var parametro = "codigo="+codigo+"&pesoTotal="+pesoTotal;
		
		$.ajax({
			url : "/frete",
			type: 'PUT',	
			data : parametro ,
			success: function(data){
				txtValorTotal.value= data;
				txtValorTotal.focus();
			},
			
			error: function(xhr, textStatus, error){
				txtValorTotal.value="0,00";
				txtValorTotal.focus();
				
			},
			
		});

	});

});
