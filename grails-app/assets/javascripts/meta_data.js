$(function(){
    $('#importCommonNames').click(function(e) {
        e.preventDefault();
        $('.spinner').removeClass('hide');
        $(this).attr('disabled', true);
        $.ajax({
            url: '/Taxonify/metaData/importData',
            dataType: 'json',
            type: 'get',
            success: function(data) {
                for(var i = 0; i < data.length; i++){
                };
                $('#importCommonNames').attr('disabled', false);
                $('.spinner').addClass('hide');
            }
        });
    });
});