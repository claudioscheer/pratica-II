/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "csbff_dependentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffDependentes.findAll", query = "SELECT c FROM CsbffDependentes c")})
public class CsbffDependentes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "dependente_cod")
    private BigDecimal dependenteCod;
    @Basic(optional = false)
    @Column(name = "dependente_nome")
    private String dependenteNome;
    @Basic(optional = false)
    @Column(name = "dependente_data_nascimento")
    private BigInteger dependenteDataNascimento;
    @Basic(optional = false)
    @Column(name = "dependente_cpf")
    private String dependenteCpf;
    @Basic(optional = false)
    @Column(name = "dependente_rg_cert_nascimento")
    private String dependenteRgCertNascimento;
    @Basic(optional = false)
    @Column(name = "dependente_imposto_de_renda")
    private boolean dependenteImpostoDeRenda;
    @Column(name = "dependente_tipo")
    private BigInteger dependenteTipo;
    @Column(name = "dependente_naturalidade")
    private String dependenteNaturalidade;
    @OneToOne(mappedBy = "dependenteCod")
    private CsbffPessoaDependente csbffPessoaDependente;

    public CsbffDependentes() {
    }

    public CsbffDependentes(BigDecimal dependenteCod) {
        this.dependenteCod = dependenteCod;
    }

    public CsbffDependentes(BigDecimal dependenteCod, String dependenteNome, BigInteger dependenteDataNascimento, String dependenteCpf, String dependenteRgCertNascimento, boolean dependenteImpostoDeRenda) {
        this.dependenteCod = dependenteCod;
        this.dependenteNome = dependenteNome;
        this.dependenteDataNascimento = dependenteDataNascimento;
        this.dependenteCpf = dependenteCpf;
        this.dependenteRgCertNascimento = dependenteRgCertNascimento;
        this.dependenteImpostoDeRenda = dependenteImpostoDeRenda;
    }

    public BigDecimal getDependenteCod() {
        return dependenteCod;
    }

    public void setDependenteCod(BigDecimal dependenteCod) {
        this.dependenteCod = dependenteCod;
    }

    public String getDependenteNome() {
        return dependenteNome;
    }

    public void setDependenteNome(String dependenteNome) {
        this.dependenteNome = dependenteNome;
    }

    public BigInteger getDependenteDataNascimento() {
        return dependenteDataNascimento;
    }

    public void setDependenteDataNascimento(BigInteger dependenteDataNascimento) {
        this.dependenteDataNascimento = dependenteDataNascimento;
    }

    public String getDependenteCpf() {
        return dependenteCpf;
    }

    public void setDependenteCpf(String dependenteCpf) {
        this.dependenteCpf = dependenteCpf;
    }

    public String getDependenteRgCertNascimento() {
        return dependenteRgCertNascimento;
    }

    public void setDependenteRgCertNascimento(String dependenteRgCertNascimento) {
        this.dependenteRgCertNascimento = dependenteRgCertNascimento;
    }

    public boolean getDependenteImpostoDeRenda() {
        return dependenteImpostoDeRenda;
    }

    public void setDependenteImpostoDeRenda(boolean dependenteImpostoDeRenda) {
        this.dependenteImpostoDeRenda = dependenteImpostoDeRenda;
    }

    public BigInteger getDependenteTipo() {
        return dependenteTipo;
    }

    public void setDependenteTipo(BigInteger dependenteTipo) {
        this.dependenteTipo = dependenteTipo;
    }

    public String getDependenteNaturalidade() {
        return dependenteNaturalidade;
    }

    public void setDependenteNaturalidade(String dependenteNaturalidade) {
        this.dependenteNaturalidade = dependenteNaturalidade;
    }

    public CsbffPessoaDependente getCsbffPessoaDependente() {
        return csbffPessoaDependente;
    }

    public void setCsbffPessoaDependente(CsbffPessoaDependente csbffPessoaDependente) {
        this.csbffPessoaDependente = csbffPessoaDependente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dependenteCod != null ? dependenteCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffDependentes)) {
            return false;
        }
        CsbffDependentes other = (CsbffDependentes) object;
        if ((this.dependenteCod == null && other.dependenteCod != null) || (this.dependenteCod != null && !this.dependenteCod.equals(other.dependenteCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffDependentes[ dependenteCod=" + dependenteCod + " ]";
    }
    
}