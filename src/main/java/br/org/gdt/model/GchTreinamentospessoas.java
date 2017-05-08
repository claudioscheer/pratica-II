/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "gch_treinamentospessoas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchTreinamentospessoas.findAll", query = "SELECT g FROM GchTreinamentospessoas g")})
@SequenceGenerator(name = "seq_trei_pescodigo", sequenceName = "sequencia_treinamento_pesssoa_codigo", allocationSize = 1)
public class GchTreinamentospessoas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trei_pescodigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_trei_pescodigo")
    private Long treiPescodigo;
    @JoinColumn(name = "trei_codigo", referencedColumnName = "trei_codigo")
    @ManyToOne(optional = false)
    private GchTreinamentos treiCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;

    public GchTreinamentospessoas() {
    }

    public GchTreinamentospessoas(Long treiPescodigo) {
        this.treiPescodigo = treiPescodigo;
    }

    public Long getTreiPescodigo() {
        return treiPescodigo;
    }

    public void setTreiPescodigo(Long treiPescodigo) {
        this.treiPescodigo = treiPescodigo;
    }

    public GchTreinamentos getTreiCodigo() {
        return treiCodigo;
    }

    public void setTreiCodigo(GchTreinamentos treiCodigo) {
        this.treiCodigo = treiCodigo;
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
        hash += (treiPescodigo != null ? treiPescodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchTreinamentospessoas)) {
            return false;
        }
        GchTreinamentospessoas other = (GchTreinamentospessoas) object;
        if ((this.treiPescodigo == null && other.treiPescodigo != null) || (this.treiPescodigo != null && !this.treiPescodigo.equals(other.treiPescodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchTreinamentospessoas[ treiPescodigo=" + treiPescodigo + " ]";
    }
    
}
