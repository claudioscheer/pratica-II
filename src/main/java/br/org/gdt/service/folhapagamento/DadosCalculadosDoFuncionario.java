package br.org.gdt.service.folhapagamento;

import br.org.gdt.model.FpEventoPeriodo;
import br.org.gdt.model.FpPeriodo;
import br.org.gdt.model.RecPessoa;
import java.util.ArrayList;
import java.util.List;

public class DadosCalculadosDoFuncionario {

    private FpPeriodo periodo;
    private RecPessoa pessoa;
    private List<FpEventoPeriodo> eventos;
    private double valorAcumulado;

    public FpPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(FpPeriodo periodo) {
        this.periodo = periodo;
    }

    public RecPessoa getPessoa() {
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

    public double getValorAcumulado() {
        return valorAcumulado;
    }

    public void setValorAcumulado(double valorAcumulado) {
        this.valorAcumulado = valorAcumulado;
    }

    public void ordenarEventosParaCalcular() {
        this.eventos.stream().sorted((x, y) -> x.getEvpEvento().getEveTipoEvento().toString().compareTo(y.getEvpEvento().getEveTipoEvento().toString()));
    }

}
