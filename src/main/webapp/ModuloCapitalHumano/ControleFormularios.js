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

        var opcoes = elemento.options;

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


    myRemote();

//    alert(parametrosPergunta.value);
//    alert(parametrosCapa.value);
//    alert(parametrosAlternativas.value);

}


function AddNovaPergunta(){
	
var divPerguntas = $('#InfoPerguntas');

var InputText = '<div class="row"><div id="perguntas"><div class="form-group col-md-5 col-sm-5"><input type="text" name="formFormulario:j_idt56:0:j_idt58" value="" class="form-control"></div></div><div class="text-left col-md-5 col-sm-5"><div class="side-by-side clearfix"><div id="0"><select id="0" style="width:400px" data-placeholder="Selecione uma alternativa" class="chosen-select" multiple="true" tabindex="4"><option value=""/><option value="1">Sim</option><option value="2">Não</option><option value="3">As Vezes</option><option value="4">Nem sempre</option><option value="5">Claro que sim</option><option value="6">Nunca</option></select></div></div></div></div>'


divPerguntas.append(InputText);

}
