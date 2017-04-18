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
@Table(name = "csbff_pessoa_dependente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffPessoaDependente.findAll", query = "SELECT c FROM CsbffPessoaDependente c")})
public class CsbffPessoaDependente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "colab_dep_codigo")
    private BigDecimal colabDepCodigo;
    @JoinColumn(name = "dependente_cod", referencedColumnName = "dependente_cod")
    @OneToOne
    private CsbffDependentes dependenteCod;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @OneToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public CsbffPessoaDependente() {
    }

    public CsbffPessoaDependente(BigDecimal colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public BigDecimal getColabDepCodigo() {
        return colabDepCodigo;
    }

    public void setColabDepCodigo(BigDecimal colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public CsbffDependentes getDependenteCod() {
        return dependenteCod;
    }

    public void setDependenteCod(CsbffDependentes dependenteCod) {
        this.dependenteCod = dependenteCod;
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
        hash += (colabDepCodigo != null ? colabDepCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffPessoaDependente)) {
            return false;
        }
        CsbffPessoaDependente other = (CsbffPessoaDependente) object;
        if ((this.colabDepCodigo == null && other.colabDepCodigo != null) || (this.colabDepCodigo != null && !this.colabDepCodigo.equals(other.colabDepCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffPessoaDependente[ colabDepCodigo=" + colabDepCodigo + " ]";
    }
    
}
