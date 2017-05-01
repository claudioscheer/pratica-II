package br.org.gdt.model;

import br.org.gdt.enums.FpTipoValorFaixa;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_faixa", sequenceName = "seq_fp_faixa", allocationSize = 1)
@Table(name = "fp_faixa")
public class FpFaixa implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long faiId;
    private FpTabelaVigencia faiTabelaVigencia;
    private double faiLimite;
    private double faiValor;
    private double faiValorDeducao;
    private FpTipoValorFaixa faiTipoValor;

    public FpFaixa() {
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
    public FpTabelaVigencia getFaiTabelaVigencia() {
        return faiTabelaVigencia;
    }

    public void setFaiTabelaVigencia(FpTabelaVigencia faiTabelaVigencia) {
        this.faiTabelaVigencia = faiTabelaVigencia;
    }

    public double getFaiLimite() {
        return faiLimite;
    }

    public void setFaiLimite(double faiLimite) {
        this.faiLimite = faiLimite;
    }

    public double getFaiValor() {
        return faiValor;
    }

    public void setFaiValor(double faiValor) {
        this.faiValor = faiValor;
    }

    public double getFaiValorDeducao() {
        return faiValorDeducao;
    }

    public void setFaiValorDeducao(double faiValorDeducao) {
        this.faiValorDeducao = faiValorDeducao;
    }

    public FpTipoValorFaixa getFaiTipoValor() {
        return faiTipoValor;
    }

    public void setFaiTipoValor(FpTipoValorFaixa faiTipoValor) {
        this.faiTipoValor = faiTipoValor;
    }

}
