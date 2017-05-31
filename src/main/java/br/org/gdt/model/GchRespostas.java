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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_respostas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchRespostas.findAll", query = "SELECT g FROM GchRespostas g")})
@SequenceGenerator(name = "seq_gch_resposta", sequenceName = "seq_gch_resposta", allocationSize = 1)
public class GchRespostas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "res_codigo")
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_resposta")
    private Long resCodigo;
    
    @Basic(optional = false)
    @Column(name = "form_codigo")
    private int formCodigo;

    public int getFormCodigo() {
        return formCodigo;
    }

    public void setFormCodigo(int formCodigo) {
        this.formCodigo = formCodigo;
    }


    @Basic(optional = false)
    @Column(name = "per_codigo")
    private long perCodigo;
    @JoinColumn(name = "alt_codigo", referencedColumnName = "alt_codigo")
    @ManyToOne(optional = false)
    private GchAlternativas altCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;

    public GchRespostas() {
    }

    public GchRespostas(Long resCodigo) {
        this.resCodigo = resCodigo;
    }

    public GchRespostas(Long resCodigo, long perCodigo) {
        this.resCodigo = resCodigo;
        this.perCodigo = perCodigo;
    }

    public Long getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Long resCodigo) {
        this.resCodigo = resCodigo;
    }

    public long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public GchAlternativas getAltCodigo() {
        return altCodigo;
    }

    public void setAltCodigo(GchAlternativas altCodigo) {
        this.altCodigo = altCodigo;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resCodigo != null ? resCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchRespostas)) {
            return false;
        }
        GchRespostas other = (GchRespostas) object;
        if ((this.resCodigo == null && other.resCodigo != null) || (this.resCodigo != null && !this.resCodigo.equals(other.resCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchRespostas[ resCodigo=" + resCodigo + " ]";
    }
    
}
