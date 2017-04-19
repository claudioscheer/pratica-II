/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "csbff_beneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffBeneficios.findAll", query = "SELECT c FROM CsbffBeneficios c")})
public class CsbffBeneficios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "beneficio_codigo")
    private BigDecimal beneficioCodigo;
    @Basic(optional = false)
    @Column(name = "beneficio_nome")
    private String beneficioNome;
    @Basic(optional = false)
    @Column(name = "beneficio_descricao")
    private String beneficioDescricao;
    @Basic(optional = false)
    @Column(name = "vinculo")
    private BigInteger vinculo;
    @Column(name = "beneficio_valor")
    private Double beneficioValor;
    @Column(name = "befencio_data_vigente")
    @Temporal(TemporalType.DATE)
    private Date befencioDataVigente;
    @JoinColumn(name = "tipo_beneficio_codigo", referencedColumnName = "tipo_beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffTipoBeneficio tipoBeneficioCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficioCodigo")
    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;

    public CsbffBeneficios() {
    }

    public CsbffBeneficios(BigDecimal beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

    public CsbffBeneficios(BigDecimal beneficioCodigo, String beneficioNome, String beneficioDescricao, BigInteger vinculo) {
        this.beneficioCodigo = beneficioCodigo;
        this.beneficioNome = beneficioNome;
        this.beneficioDescricao = beneficioDescricao;
        this.vinculo = vinculo;
    }

    public BigDecimal getBeneficioCodigo() {
        return beneficioCodigo;
    }

    public void setBeneficioCodigo(BigDecimal beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

    public String getBeneficioNome() {
        return beneficioNome;
    }

    public void setBeneficioNome(String beneficioNome) {
        this.beneficioNome = beneficioNome;
    }

    public String getBeneficioDescricao() {
        return beneficioDescricao;
    }

    public void setBeneficioDescricao(String beneficioDescricao) {
        this.beneficioDescricao = beneficioDescricao;
    }

    public BigInteger getVinculo() {
        return vinculo;
    }

    public void setVinculo(BigInteger vinculo) {
        this.vinculo = vinculo;
    }

    public Double getBeneficioValor() {
        return beneficioValor;
    }

    public void setBeneficioValor(Double beneficioValor) {
        this.beneficioValor = beneficioValor;
    }

    public Date getBefencioDataVigente() {
        return befencioDataVigente;
    }

    public void setBefencioDataVigente(Date befencioDataVigente) {
        this.befencioDataVigente = befencioDataVigente;
    }

    public CsbffTipoBeneficio getTipoBeneficioCodigo() {
        return tipoBeneficioCodigo;
    }

    public void setTipoBeneficioCodigo(CsbffTipoBeneficio tipoBeneficioCodigo) {
        this.tipoBeneficioCodigo = tipoBeneficioCodigo;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffPessoaBeneficio> getCsbffPessoaBeneficioList() {
        return csbffPessoaBeneficioList;
    }

    public void setCsbffPessoaBeneficioList(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (beneficioCodigo != null ? beneficioCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffBeneficios)) {
            return false;
        }
        CsbffBeneficios other = (CsbffBeneficios) object;
        if ((this.beneficioCodigo == null && other.beneficioCodigo != null) || (this.beneficioCodigo != null && !this.beneficioCodigo.equals(other.beneficioCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffBeneficios[ beneficioCodigo=" + beneficioCodigo + " ]";
    }
    
}
