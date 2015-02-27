$(function(){
	$('#importBrazil').click(function(e) {
		e.preventDefault();
		$('.spinner').removeClass('hide');
		$(this).attr('disabled', true);
		$.ajax({
			url: '/Especies/taxa/importTaxa',
			dataType: 'json',
			type: 'get',
			success: function(data) {
				for(var i = 0; i < data.length; i++){
					$('#taxa-table tbody')
						.prepend('<tr><td>'+data[i].kingdomName+'</td><td>'+
								data[i].phylumName +'</td><td>'+
								data[i].className +'</td><td>'+
								data[i].orderName +'</td><td>'+
								data[i].familyName +'</td><td>'+
								data[i].scientificName +'</td><td>'+
								data[i].nameStatus +'</td><td>'+
								data[i].sourceId+'</td><td>'+
								data[i].speciesPlusId +'</td><td>'+
			                    data[i].gbifId +'</td><td>'+
			                    data[i].gbifName +'</td>'+
								'<td></td></tr>');
				};
				$('#importBrazil').attr('disabled', false);
				$('.spinner').addClass('hide');
			}
		});
	});
});