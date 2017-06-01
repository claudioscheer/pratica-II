package br.org.gdt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seq_fp_evento_periodo", sequenceName = "seq_fp_evento_periodo", allocationSize = 1)
@Table(name = "fp_evento_periodo")
public class FpEventoPeriodo implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long evpId;
    private FpEvento evpEvento;
    private FpFolhaPeriodo evpFolhaPeriodo;
    private double evpValor;
    private double evpValorReferencia;
    private boolean evpEventoPadrao;
    private boolean jaCalculado;
    private boolean eventoAlteradoManualmente;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento_periodo")
    public long getEvpId() {
        return this.evpId;
    }

    public void setEvpId(long evpId) {
        this.evpId = evpId;
    }

    @ManyToOne
    public FpEvento getEvpEvento() {
        return evpEvento;
    }

    public void setEvpEvento(FpEvento evpEvento) {
        this.evpEvento = evpEvento;
    }

    @ManyToOne
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

    public double getEvpValorReferencia() {
        return evpValorReferencia;
    }

    public void setEvpValorReferencia(double evpValorReferencia) {
        this.evpValorReferencia = evpValorReferencia;
    }

    public boolean isEvpEventoPadrao() {
        return evpEventoPadrao;
    }

    public void setEvpEventoPadrao(boolean evpEventoPadrao) {
        this.evpEventoPadrao = evpEventoPadrao;
    }

    @Transient
    public boolean isJaCalculado() {
        return jaCalculado;
    }

    public void setJaCalculado(boolean jaCalculado) {
        this.jaCalculado = jaCalculado;
    }

    @Transient
    public boolean isEventoAlteradoManualmente() {
        return eventoAlteradoManualmente;
    }

    public void setEventoAlteradoManualmente(boolean eventoAlteradoManualmente) {
        this.eventoAlteradoManualmente = eventoAlteradoManualmente;
    }

}
