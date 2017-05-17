package br.org.gdt.service.folhapagamento;

import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DadosCalculadosDoFuncionario {

    private FpPeriodo periodo;
    private RecPessoa pessoa;
    private List<FpEventoPeriodo> eventos;

    public FpPeriodo getPeriodo() {
        if (periodo == null) {
            periodo = new FpPeriodo();
        }
        return periodo;
    }

    public void setPeriodo(FpPeriodo periodo) {
        this.periodo = periodo;
    }

    public RecPessoa getPessoa() {
        if (pessoa == null) {
            pessoa = new RecPessoa();
        }
        return pessoa;
    }

    public void setPessoa(RecPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<FpEventoPeriodo> getEventos() {
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        return eventos;
    }

    public void setEventos(List<FpEventoPeriodo> eventos) {
        this.eventos = eventos;
    }

}
