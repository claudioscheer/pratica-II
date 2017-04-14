package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_periodo", sequenceName = "seq_fp_periodo", allocationSize = 1)
@Table(name = "fp_periodo")
public class FpPeriodo implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private int perId;
    private int perMes;
    private int perAno;
    private int perDiasUteis;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_periodo")
    public int getPerId() {
        return this.perId;
    }

    public void setPerId(int perId) {
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

}
