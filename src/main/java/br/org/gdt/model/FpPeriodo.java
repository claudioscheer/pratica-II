package br.org.gdt.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name = "seq_fp_periodo", sequenceName = "seq_fp_periodo", allocationSize = 1)
@Table(name = "fp_periodo")
public class FpPeriodo implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long perId;
    private int perMes;
    private int perAno;
    private int perDiasUteis;
    private int perDiasNaoUteis;
    private Date perDataInicial;
    private Date perDataFinal;
    private boolean perAtivo;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_periodo")
    public long getPerId() {
        return this.perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }

    public int getPerMes() {
        return perMes;
    }

    public void setPerMes(int perMes) {
        this.perMes = perMes;
    }

    public int getPerAno() {
        return perAno;
    }

    public void setPerAno(int perAno) {
        this.perAno = perAno;
    }

    public int getPerDiasUteis() {
        return perDiasUteis;
    }

    public void setPerDiasUteis(int perDiasUteis) {
        this.perDiasUteis = perDiasUteis;
    }

    public int getPerDiasNaoUteis() {
        return perDiasNaoUteis;
    }

    public void setPerDiasNaoUteis(int perDiasNaoUteis) {
        this.perDiasNaoUteis = perDiasNaoUteis;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPerDataInicial() {
        return perDataInicial;
    }

    public void setPerDataInicial(Date perDataInicial) {
        this.perDataInicial = perDataInicial;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPerDataFinal() {
        return perDataFinal;
    }

    public void setPerDataFinal(Date perDataFinal) {
        this.perDataFinal = perDataFinal;
    }

    public boolean isPerAtivo() {
        return perAtivo;
    }

    public void setPerAtivo(boolean perAtivo) {
        this.perAtivo = perAtivo;
    }

}
