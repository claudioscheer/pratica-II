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
@Table(name = "csbff_pessoa_beneficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffPessoaBeneficio.findAll", query = "SELECT c FROM CsbffPessoaBeneficio c")})
public class CsbffPessoaBeneficio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_beneficio_codigo")
    private BigDecimal pessoaBeneficioCodigo;
    @JoinColumn(name = "beneficio_codigo", referencedColumnName = "beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffBeneficios beneficioCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public CsbffPessoaBeneficio() {
    }

    public CsbffPessoaBeneficio(BigDecimal pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public BigDecimal getPessoaBeneficioCodigo() {
        return pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(BigDecimal pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public CsbffBeneficios getBeneficioCodigo() {
        return beneficioCodigo;
    }

    public void setBeneficioCodigo(CsbffBeneficios beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

    public RecPessoa_1 getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa_1 recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaBeneficioCodigo != null ? pessoaBeneficioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffPessoaBeneficio)) {
            return false;
        }
        CsbffPessoaBeneficio other = (CsbffPessoaBeneficio) object;
        if ((this.pessoaBeneficioCodigo == null && other.pessoaBeneficioCodigo != null) || (this.pessoaBeneficioCodigo != null && !this.pessoaBeneficioCodigo.equals(other.pessoaBeneficioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffPessoaBeneficio[ pessoaBeneficioCodigo=" + pessoaBeneficioCodigo + " ]";
    }
    
}
