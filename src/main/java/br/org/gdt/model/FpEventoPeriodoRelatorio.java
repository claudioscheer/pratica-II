package br.org.gdt.model;

public class FpEventoPeriodoRelatorio {

    private long codigoEvento;
    private String nomeEvento;
    private String valorReferencia;
    private String valorVencimento;
    private String valorDesconto;

    public FpEventoPeriodoRelatorio(long codigoEvento, String nomeEvento, String valorReferencia, String valorVencimento, String valorDesconto) {
        this.codigoEvento = codigoEvento;
        this.nomeEvento = nomeEvento;
        this.valorReferencia = valorReferencia;
        this.valorVencimento = valorVencimento;
        this.valorDesconto = valorDesconto;
    }

    public long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(String valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public String getValorVencimento() {
        return valorVencimento;
    }

    public void setValorVencimento(String valorVencimento) {
        this.valorVencimento = valorVencimento;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(String valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

}
