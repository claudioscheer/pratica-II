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
@Table(name = "csbff_historico_salario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffHistoricoSalario.findAll", query = "SELECT c FROM CsbffHistoricoSalario c")})
public class CsbffHistoricoSalario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "salhis_codigo")
    private BigDecimal salhisCodigo;
    @JoinColumn(name = "salario_codigo", referencedColumnName = "salario_codigo")
    @ManyToOne(optional = false)
    private CsbffSalario salarioCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public CsbffHistoricoSalario() {
    }

    public CsbffHistoricoSalario(BigDecimal salhisCodigo) {
        this.salhisCodigo = salhisCodigo;
    }

    public BigDecimal getSalhisCodigo() {
        return salhisCodigo;
    }

    public void setSalhisCodigo(BigDecimal salhisCodigo) {
        this.salhisCodigo = salhisCodigo;
    }

    public CsbffSalario getSalarioCodigo() {
        return salarioCodigo;
    }

    public void setSalarioCodigo(CsbffSalario salarioCodigo) {
        this.salarioCodigo = salarioCodigo;
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
        hash += (salhisCodigo != null ? salhisCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffHistoricoSalario)) {
            return false;
        }
        CsbffHistoricoSalario other = (CsbffHistoricoSalario) object;
        if ((this.salhisCodigo == null && other.salhisCodigo != null) || (this.salhisCodigo != null && !this.salhisCodigo.equals(other.salhisCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffHistoricoSalario[ salhisCodigo=" + salhisCodigo + " ]";
    }
    
}
