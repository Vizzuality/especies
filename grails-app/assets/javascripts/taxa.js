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
								data[i].sourceId+'</td><td></td></tr>');
				};
				$('#linkGbfiEtAl').attr('disabled', false);
				$('#importBrazil').attr('disabled', false);
				$('.spinner').addClass('hide');
			}
		});
	});
	$('#linkGbfiEtAl').click(function(e) {
		e.preventDefault();
		$('.spinner').removeClass('hide');
		$.ajax({
			url: '/Especies/taxa/linkGbifAndSpeciesPlusData',
			dataType: 'json',
			type: 'get',
			success: function(data) {
				$('#taxa-table tbody').empty();
				for(var i = 0; i < data.length; i++){
					$('#taxa-table tbody')
					.prepend('<tr><td>'+data[i].kingdomName+'</td><td>'+
						data[i].phylumName +'</td><td>'+
						data[i].className +'</td><td>'+
						data[i].orderName +'</td><td>'+
						data[i].familyName +'</td><td>'+
						data[i].scientificName +'</td><td>'+
						data[i].sourceId+'</td><td></td></tr>');
				};
				$('.spinner').addClass('hide');
			}
		});
	});
});