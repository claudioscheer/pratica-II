/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_alternativasperguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchAlternativasperguntas.findAll", query = "SELECT g FROM GchAlternativasperguntas g")})
public class GchAlternativasperguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alp_codigo")
    private Long alpCodigo;
    @Basic(optional = false)
    @Column(name = "alt_codigo")
    private long altCodigo;
    @JoinColumn(name = "alp_codigo", referencedColumnName = "alt_codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private GchAlternativas gchAlternativas;
    @JoinColumn(name = "per_codigo", referencedColumnName = "per_codigo")
    @ManyToOne(optional = false)
    private GchPerguntas perCodigo;

    public GchAlternativasperguntas() {
    }

    public GchAlternativasperguntas(Long alpCodigo) {
        this.alpCodigo = alpCodigo;
    }

    public GchAlternativasperguntas(Long alpCodigo, long altCodigo) {
        this.alpCodigo = alpCodigo;
        this.altCodigo = altCodigo;
    }

    public Long getAlpCodigo() {
        return alpCodigo;
    }

    public void setAlpCodigo(Long alpCodigo) {
        this.alpCodigo = alpCodigo;
    }

    public long getAltCodigo() {
        return altCodigo;
    }

    public void setAltCodigo(long altCodigo) {
        this.altCodigo = altCodigo;
    }

    public GchAlternativas getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public GchPerguntas getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(GchPerguntas perCodigo) {
        this.perCodigo = perCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alpCodigo != null ? alpCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchAlternativasperguntas)) {
            return false;
        }
        GchAlternativasperguntas other = (GchAlternativasperguntas) object;
        if ((this.alpCodigo == null && other.alpCodigo != null) || (this.alpCodigo != null && !this.alpCodigo.equals(other.alpCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchAlternativasperguntas[ alpCodigo=" + alpCodigo + " ]";
    }
    
}
