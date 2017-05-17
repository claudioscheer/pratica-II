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


    alert(parametrosPergunta.value);
    alert(parametrosCapa.value);
    alert(parametrosAlternativas.value);

}
