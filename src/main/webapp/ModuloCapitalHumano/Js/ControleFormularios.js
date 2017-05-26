$(window).load(function() {      //Do the code in the {}s when the window has loaded 
  $("#loader").fadeOut("fast");  //Fade out the #loader div
});

function MontarPerguntasAlternativas() {

    var parametrosCapa = document.getElementById('formFormulario:TxbParametrosCapa');
    var parametrosPergunta = document.getElementById('formFormulario:TxbParametrosPergunta');
    var parametrosAlternativas = document.getElementById('formFormulario:TxbParametrosAlternativas');

    parametrosCapa.value = "";
    parametrosPergunta.value = "";
    parametrosAlternativas.value = "";

    var inputsCapa = $('#InfoCapa').find('input:text');
    var inputsPergunta = $('#InfoPerguntas #perguntas').find('input:text');
    var alternativasPergunta = $('#InfoPerguntas').find('select');


    //Percorre inputs da capa e adiciona nos parametros para recuperar na Bean
    inputsCapa.get().forEach(function (elemento, indice, array) {

        var quebra = "";

        if ((indice + 1) !== array.length) {
            quebra = "§";
        }
        
        
        parametrosCapa.value += elemento.value + quebra;

    });

    //Percorre inputs das perguntas e adiciona nos parametros para recuperar na Bean
    inputsPergunta.get().forEach(function (elemento, indice, array) {

        var quebra = "";

        if ((indice + 1) !== array.length) {
            quebra = "§";
        }

        parametrosPergunta.value += elemento.value + quebra;

    });

    //Percorre as linhas de alternativas e para cada alternativa busca os valores selecionados
    alternativasPergunta.get().forEach(function (elemento, indice, array) {

        var opcoes = elemento.selectedOptions;

        for (var i = 0; i < opcoes.length; i++) {

            var quebra = "";

            if ((i + 1) !== opcoes.length) {
                quebra = "§";
            }

            parametrosAlternativas.value += opcoes[i].value + quebra;
        }


        if ((indice + 1) !== array.length) {
            parametrosAlternativas.value += "¬";
        }

    });


//    alert(parametrosPergunta.value);;
//    alert(parametrosCapa.value);
//    alert(parametrosAlternativas.value);

}


function AddNovaPergunta(){
	
var divPerguntas = $('#InfoPerguntas');

var id = parseInt($('#SequencialPergunta')[0].value) + 1;

if(id === 1){ //Add a primeira pergunta
    document.getElementById('botaoSalvar').onmouseover=function(){MontarPerguntasAlternativas();};
}

var incrementa = parseInt($('#SequencialPergunta')[0].value) + 1;

$('#SequencialPergunta')[0].value = incrementa;


var divAlternativas = $('#TxbAlternativasDisponiveis');

var InputText = '<div class="row" id="'+id+'"><div id="perguntas"><div class="form-group col-md-5 col-sm-5"><input type="text" name="formFormulario:j_idt56:0:j_idt58" value="" class="form-control"></div></div><div class="text-left col-md-5 col-sm-5"><div class="side-by-side clearfix"><div id="0"><select id="0" style="width:400px" data-placeholder="Selecione uma alternativa" class="chosen-select" multiple="true" tabindex="4">'+divAlternativas[0].children[0].innerHTML+'</select></div></div></div><input type="button" class="btn btn-danger" value="Remover" onclick="removerLinha('+id+')"/></div>';

divPerguntas.append(InputText);


$(".chosen-select").chosen({
    
        no_results_text: "Alternativa não encontrada",
        display_selected_options: false,
        max_shown_results: 5,
        hide_results_on_select: true
      
    
    });

}

function CancelarTudo(){
    
    $('#InfoPerguntas').empty();
    $('#SequencialPergunta')[0].value = 1;
}


function removerLinha(id){
    
    $('#'+id).remove();
    
}