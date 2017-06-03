function MascaraCPF(cpf) {
    cpf = cpf.replace(/\D/g, "");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
    console.log(cpf);
    return cpf;
}

function MascaraData(campoData) {
    var data = campoData;
    if (data.length === 2) {
        data = data + '/';
        document.forms[0].data = data;
    }
    if (data.length === 5) {
        data = data + '/';
        document.forms[0].data = data;
    }
    return data;
}

function MascaraTelefone(telefone) {
    telefone = telefone.replace(/\D/g, "");
    telefone = telefone.replace(/^(\d\d)(\d)/g, "($1) $2");
    telefone = telefone.replace(/(\d{4})(\d)/, "$1-$2");
    return telefone;
}

function MascaraValorMonetario(valor) {
    v = valor;
    v = v.replace(/\D/g, "");
    v = v.replace(/(\d{1})(\d{4})$/, "$1.$2");
    v = v.replace(/(\d{1})(\d{1,1})$/, "$1.$2");
    return v;
}

function cep(cep) {
    cep = cep.replace(/\D/g, "");
    cep = cep.replace(/(\d{2})(\d)/, "$1.$2");
    cep = cep.replace(/(\d{3})(\d{1,3})$/, "$1-$2");
    return cep;
}
function MascaraHora(Hora, campo){
   var hora01 = '';
   hora01 = hora01 + Hora;
   if (hora01.length === 2){
      hora01 = hora01 + ':';
      campo.value = hora01;
   }
   if (hora01.length === 5){
      Verifica_Hora(campo);
   }
}
function VerificaHora(campo){
   hrs = (campo.value.substring(0,2));
   min = (campo.value.substring(3,5));
   estado = "";
   if ((hrs < 00 ) || (hrs > 23) || ( min < 00) ||( min > 59)){
      estado = "errada";
   }
   if (campo.value === "") {
      estado = "errada";
   }
   if (estado === "errada") {
      alert("Hora invalida!");
      campo.focus();
   }
} 