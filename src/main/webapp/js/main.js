jQuery(document).ready(function(){
	jQuery('.ingredient:not(:has(.sinStock))').click(function(){
		if($(this).hasClass('enabled')){
			$(this).removeClass('enabled')
				   .find('.ingredientValue')
				   .removeClass('enabled')
				   .val(0);
			$(this).find('.descuento')
				   .removeClass('enabled');
			$(this).find('.descuentoInput')
			   	   .val(0)
			   	   .change();
			if($('.ingredient.enabled').size() <= 0){
				$('#buttonAdd').attr('disabled','true');
			}
		}else{
			$(this).addClass('enabled')
				   .find('.ingredientValue')
				   .addClass('enabled');
			$(this).find('.descuento')
			   	   .addClass('enabled');
			$('#buttonAdd').removeAttr('disabled');
		}
	}).find('.ingredientValue').click(function(e) {
  		return false;
	});
	jQuery('.ingredient:not(:has(.sinStock))')
	   .find('.descuento').click(function(e) {
  		return false;
	});
	jQuery('.descuentoInput')
	   .change(function() {
		   console.log('a');
		   var pId = $(this).attr('id');
		   var valueD = $(this).val();
		   if(valueD>0 && valueD<=100){
			   $('.ingredient:has(#'+pId+') .precio-ingrediente')
			   	.addClass('tachado');
			   $('.ingredient:has(#'+pId+') .precio-descuento')
			    .addClass('enabled')
			    .text('-$'+(valueD*parseFloat($('.ingredient:has(#'+pId+') .precio-ingrediente').text())/100));
		   }else{
			   $('.ingredient:has(#'+pId+') .precio-ingrediente')
			   	.removeClass('tachado');
			   $('.ingredient:has(#'+pId+') .precio-descuento')
			    .removeClass('enabled')
			    .text('');
		   }
	});
});
