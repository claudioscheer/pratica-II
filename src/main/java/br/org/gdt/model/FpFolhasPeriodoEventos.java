/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.modelOld.FpEvento;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "fp_folhas_periodo_eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpFolhasPeriodoEventos.findAll", query = "SELECT f FROM FpFolhasPeriodoEventos f")})
public class FpFolhasPeriodoEventos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fpe_id")
    private Integer fpeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "fpe_valor")
    private BigDecimal fpeValor;
    @JoinColumn(name = "eve_id_fp_evento", referencedColumnName = "eve_id")
    @ManyToOne
    private FpEvento eveIdFpEvento;
    @JoinColumn(name = "flp_id_fp_folhas_periodo", referencedColumnName = "flp_id")
    @ManyToOne
    private FpFolhasPeriodo flpIdFpFolhasPeriodo;

    public FpFolhasPeriodoEventos() {
    }

    public FpFolhasPeriodoEventos(Integer fpeId) {
        this.fpeId = fpeId;
    }

    public FpFolhasPeriodoEventos(Integer fpeId, BigDecimal fpeValor) {
        this.fpeId = fpeId;
        this.fpeValor = fpeValor;
    }

    public Integer getFpeId() {
        return fpeId;
    }

    public void setFpeId(Integer fpeId) {
        this.fpeId = fpeId;
    }

    public BigDecimal getFpeValor() {
        return fpeValor;
    }

    public void setFpeValor(BigDecimal fpeValor) {
        this.fpeValor = fpeValor;
    }

    public FpEvento getEveIdFpEvento() {
        return eveIdFpEvento;
    }

    public void setEveIdFpEvento(FpEvento eveIdFpEvento) {
        this.eveIdFpEvento = eveIdFpEvento;
    }

    public FpFolhasPeriodo getFlpIdFpFolhasPeriodo() {
        return flpIdFpFolhasPeriodo;
    }

    public void setFlpIdFpFolhasPeriodo(FpFolhasPeriodo flpIdFpFolhasPeriodo) {
        this.flpIdFpFolhasPeriodo = flpIdFpFolhasPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpeId != null ? fpeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpFolhasPeriodoEventos)) {
            return false;
        }
        FpFolhasPeriodoEventos other = (FpFolhasPeriodoEventos) object;
        if ((this.fpeId == null && other.fpeId != null) || (this.fpeId != null && !this.fpeId.equals(other.fpeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.FpFolhasPeriodoEventos[ fpeId=" + fpeId + " ]";
    }
    
}
