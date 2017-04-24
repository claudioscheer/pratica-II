package br.org.gdt.model;

import br.org.gdt.enums.FpTipoValorFaixa;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seq_fp_faixa", sequenceName = "seq_fp_faixa", allocationSize = 1)
@Table(name = "fp_faixa")
public class FpFaixa implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long faiId;
    private FpTabela faiTabela;
    private double faiMinimo;
    private double faiMaximo;
    private double faiValor;
    private FpTipoValorFaixa faiTipoValor;
    private int faiOrdem;

    public FpFaixa() {
    }

    public FpFaixa(int faiOrdem) {
        this.faiOrdem = faiOrdem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_faixa")
    public long getFaiId() {
        return faiId;
    }

    public void setFaiId(long faiId) {
        this.faiId = faiId;
    }

    @ManyToOne
    public FpTabela getFaiTabela() {
        return faiTabela;
    }

    public void setFaiTabela(FpTabela faiTabela) {
        this.faiTabela = faiTabela;
    }

    public double getFaiMinimo() {
        return faiMinimo;
    }

    public void setFaiMinimo(double faiMinimo) {
        this.faiMinimo = faiMinimo;
    }

    public double getFaiMaximo() {
        return faiMaximo;
    }

    public void setFaiMaximo(double faiMaximo) {
        this.faiMaximo = faiMaximo;
    }

    public double getFaiValor() {
        return faiValor;
    }

    public void setFaiValor(double faiValor) {
        this.faiValor = faiValor;
    }

    public FpTipoValorFaixa getFaiTipoValor() {
        return faiTipoValor;
    }

    public void setFaiTipoValor(FpTipoValorFaixa faiTipoValor) {
        this.faiTipoValor = faiTipoValor;
    }

    @Transient
    public int getFaiOrdem() {
        return faiOrdem;
    }

    public void setFaiOrdem(int faiOrdem) {
        this.faiOrdem = faiOrdem;
    }

}
