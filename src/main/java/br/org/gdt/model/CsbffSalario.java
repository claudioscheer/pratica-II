/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "csbff_salario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffSalario.findAll", query = "SELECT c FROM CsbffSalario c")})
public class CsbffSalario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "salario_codigo")
    private BigDecimal salarioCodigo;
    @Basic(optional = false)
    @Column(name = "salario_valor")
    private double salarioValor;
    @Basic(optional = false)
    @Column(name = "salario_data_inicio")
    @Temporal(TemporalType.DATE)
    private Date salarioDataInicio;
    @Column(name = "salario_data_final")
    @Temporal(TemporalType.DATE)
    private Date salarioDataFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salarioCodigo")
    private List<CsbffHistoricoSalario> csbffHistoricoSalarioList;

    public CsbffSalario() {
    }

    public CsbffSalario(BigDecimal salarioCodigo) {
        this.salarioCodigo = salarioCodigo;
    }

    public CsbffSalario(BigDecimal salarioCodigo, double salarioValor, Date salarioDataInicio) {
        this.salarioCodigo = salarioCodigo;
        this.salarioValor = salarioValor;
        this.salarioDataInicio = salarioDataInicio;
    }

    public BigDecimal getSalarioCodigo() {
        return salarioCodigo;
    }

    public void setSalarioCodigo(BigDecimal salarioCodigo) {
        this.salarioCodigo = salarioCodigo;
    }

    public double getSalarioValor() {
        return salarioValor;
    }

    public void setSalarioValor(double salarioValor) {
        this.salarioValor = salarioValor;
    }

    public Date getSalarioDataInicio() {
        return salarioDataInicio;
    }

    public void setSalarioDataInicio(Date salarioDataInicio) {
        this.salarioDataInicio = salarioDataInicio;
    }

    public Date getSalarioDataFinal() {
        return salarioDataFinal;
    }

    public void setSalarioDataFinal(Date salarioDataFinal) {
        this.salarioDataFinal = salarioDataFinal;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffHistoricoSalario> getCsbffHistoricoSalarioList() {
        return csbffHistoricoSalarioList;
    }

    public void setCsbffHistoricoSalarioList(List<CsbffHistoricoSalario> csbffHistoricoSalarioList) {
        this.csbffHistoricoSalarioList = csbffHistoricoSalarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salarioCodigo != null ? salarioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffSalario)) {
            return false;
        }
        CsbffSalario other = (CsbffSalario) object;
        if ((this.salarioCodigo == null && other.salarioCodigo != null) || (this.salarioCodigo != null && !this.salarioCodigo.equals(other.salarioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffSalario[ salarioCodigo=" + salarioCodigo + " ]";
    }
    
}
