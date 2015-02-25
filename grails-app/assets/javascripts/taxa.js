$(function(){
	$('#importBrazil').click(function(e) {
		e.preventDefault();
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
				$('#addSpeciesPlus').attr('disabled', false);
			}
		});
	});
	$('#addSpeciesPlus').click(function(e) {
		e.preventDefault();
		$.ajax({
			url: '/Especies/taxa/addSpeciesPlusData',
			dataType: 'json',
			type: 'get',
			success: function(data) {
				console.log('success!');
			}
		});
	});
});