/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "fp_faixas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpFaixas.findAll", query = "SELECT f FROM FpFaixas f")})
public class FpFaixas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fai_id")
    private Integer faiId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "fai_minimo")
    private BigDecimal faiMinimo;
    @Basic(optional = false)
    @Column(name = "fai_maximo")
    private BigDecimal faiMaximo;
    @Basic(optional = false)
    @Column(name = "fai_valor")
    private BigDecimal faiValor;
    @Basic(optional = false)
    @Column(name = "fai_tipovalor")
    private Character faiTipovalor;
    @Basic(optional = false)
    @Column(name = "fai_ativo")
    private boolean faiAtivo;

    public FpFaixas() {
    }

    public FpFaixas(Integer faiId) {
        this.faiId = faiId;
    }

    public FpFaixas(Integer faiId, BigDecimal faiMinimo, BigDecimal faiMaximo, BigDecimal faiValor, Character faiTipovalor, boolean faiAtivo) {
        this.faiId = faiId;
        this.faiMinimo = faiMinimo;
        this.faiMaximo = faiMaximo;
        this.faiValor = faiValor;
        this.faiTipovalor = faiTipovalor;
        this.faiAtivo = faiAtivo;
    }

    public Integer getFaiId() {
        return faiId;
    }

    public void setFaiId(Integer faiId) {
        this.faiId = faiId;
    }

    public BigDecimal getFaiMinimo() {
        return faiMinimo;
    }

    public void setFaiMinimo(BigDecimal faiMinimo) {
        this.faiMinimo = faiMinimo;
    }

    public BigDecimal getFaiMaximo() {
        return faiMaximo;
    }

    public void setFaiMaximo(BigDecimal faiMaximo) {
        this.faiMaximo = faiMaximo;
    }

    public BigDecimal getFaiValor() {
        return faiValor;
    }

    public void setFaiValor(BigDecimal faiValor) {
        this.faiValor = faiValor;
    }

    public Character getFaiTipovalor() {
        return faiTipovalor;
    }

    public void setFaiTipovalor(Character faiTipovalor) {
        this.faiTipovalor = faiTipovalor;
    }

    public boolean getFaiAtivo() {
        return faiAtivo;
    }

    public void setFaiAtivo(boolean faiAtivo) {
        this.faiAtivo = faiAtivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faiId != null ? faiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpFaixas)) {
            return false;
        }
        FpFaixas other = (FpFaixas) object;
        if ((this.faiId == null && other.faiId != null) || (this.faiId != null && !this.faiId.equals(other.faiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.FpFaixas[ faiId=" + faiId + " ]";
    }
    
}
