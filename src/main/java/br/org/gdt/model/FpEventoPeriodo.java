package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_evento_periodo", sequenceName = "seq_fp_evento_periodo", allocationSize = 1)
@Table(name = "fp_evento_periodo")
public class FpEventoPeriodo implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long evpId;
    private FpEvento evpEvento;
    private FpFolhaPeriodo evpFolhaPeriodo;
    private double evpValor;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento_periodo")
    public long getEvpId() {
        return this.evpId;
    }

    public void setEvpId(long evpId) {
        this.evpId = evpId;
    }

    public FpEvento getEvpEvento() {
        return evpEvento;
    }

    public void setEvpEvento(FpEvento evpEvento) {
        this.evpEvento = evpEvento;
    }

    public FpFolhaPeriodo getEvpFolhaPeriodo() {
        return evpFolhaPeriodo;
    }

    public void setEvpFolhaPeriodo(FpFolhaPeriodo evpFolhaPeriodo) {
        this.evpFolhaPeriodo = evpFolhaPeriodo;
    }

    public double getEvpValor() {
        return evpValor;
    }

    public void setEvpValor(double evpValor) {
        this.evpValor = evpValor;
    }

}
