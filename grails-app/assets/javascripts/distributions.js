$(function(){
	$('#importDistributions').click(function(e) {
		e.preventDefault();
		$('.spinner').removeClass('hide');
		$(this).attr('disabled', true);
		$.ajax({
			url: '/Taxonify/distributions/importData',
			dataType: 'json',
			type: 'get',
			success: function(data) {
				for(var i = 0; i < data.length; i++){
				};
				$('#importDistributions').attr('disabled', false);
				$('.spinner').addClass('hide');
			}
		});
	});
});