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
    private double valorBaseINSS;
    private double valorBaseFGTS;
    private double valorBaseIRRF;

    public double getValorBaseINSS() {
        return valorBaseINSS;
    }

    public void setValorBaseINSS(double valorBaseINSS) {
        this.valorBaseINSS = valorBaseINSS;
    }

    public double getValorBaseFGTS() {
        return valorBaseFGTS;
    }

    public void setValorBaseFGTS(double valorBaseFGTS) {
        this.valorBaseFGTS = valorBaseFGTS;
    }

    public double getValorBaseIRRF() {
        return valorBaseIRRF;
    }

    public void setValorBaseIRRF(double valorBaseIRRF) {
        this.valorBaseIRRF = valorBaseIRRF;
    }

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
