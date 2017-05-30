$('#formFormulario:enviarEmail').submit(function() {
    $('#wait').show();
    $.post('/somepage.htm', function() {
        $('#wait').hide();
    });
    return false;
});