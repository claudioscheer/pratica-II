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
@Table(name = "csbff_cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffCargos.findAll", query = "SELECT c FROM CsbffCargos c")})
public class CsbffCargos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "cargo_codigo")
    private BigDecimal cargoCodigo;
    @Basic(optional = false)
    @Column(name = "cargo_nome")
    private String cargoNome;
    @Basic(optional = false)
    @Column(name = "cargo_cbo")
    private BigInteger cargoCbo;
    @Column(name = "cargo_codigo_superior")
    private BigInteger cargoCodigoSuperior;
    @Basic(optional = false)
    @Column(name = "cargo_data_de_criacao")
    @Temporal(TemporalType.DATE)
    private Date cargoDataDeCriacao;
    @Column(name = "cargo_valor_salario")
    private Double cargoValorSalario;
    @Column(name = "cargo_descricao")
    private String cargoDescricao;
    @Column(name = "cargo_data_ultima_alteracao")
    @Temporal(TemporalType.DATE)
    private Date cargoDataUltimaAlteracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoCodigo")
    private List<CsbffCargosHistorico> csbffCargosHistoricoList;
    @JoinColumn(name = "tipo_cargo_cod_csbff_tipos_de_cargos", referencedColumnName = "tipo_cargo_cod")
    @ManyToOne
    private CsbffTiposDeCargos tipoCargoCodCsbffTiposDeCargos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoCodigo")
    private List<RecVaga_1> recVagaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoCodigo")
    private List<RecPessoa_1> recPessoaList;

    public CsbffCargos() {
    }

    public CsbffCargos(BigDecimal cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public CsbffCargos(BigDecimal cargoCodigo, String cargoNome, BigInteger cargoCbo, Date cargoDataDeCriacao) {
        this.cargoCodigo = cargoCodigo;
        this.cargoNome = cargoNome;
        this.cargoCbo = cargoCbo;
        this.cargoDataDeCriacao = cargoDataDeCriacao;
    }

    public BigDecimal getCargoCodigo() {
        return cargoCodigo;
    }

    public void setCargoCodigo(BigDecimal cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public BigInteger getCargoCbo() {
        return cargoCbo;
    }

    public void setCargoCbo(BigInteger cargoCbo) {
        this.cargoCbo = cargoCbo;
    }

    public BigInteger getCargoCodigoSuperior() {
        return cargoCodigoSuperior;
    }

    public void setCargoCodigoSuperior(BigInteger cargoCodigoSuperior) {
        this.cargoCodigoSuperior = cargoCodigoSuperior;
    }

    public Date getCargoDataDeCriacao() {
        return cargoDataDeCriacao;
    }

    public void setCargoDataDeCriacao(Date cargoDataDeCriacao) {
        this.cargoDataDeCriacao = cargoDataDeCriacao;
    }

    public Double getCargoValorSalario() {
        return cargoValorSalario;
    }

    public void setCargoValorSalario(Double cargoValorSalario) {
        this.cargoValorSalario = cargoValorSalario;
    }

    public String getCargoDescricao() {
        return cargoDescricao;
    }

    public void setCargoDescricao(String cargoDescricao) {
        this.cargoDescricao = cargoDescricao;
    }

    public Date getCargoDataUltimaAlteracao() {
        return cargoDataUltimaAlteracao;
    }

    public void setCargoDataUltimaAlteracao(Date cargoDataUltimaAlteracao) {
        this.cargoDataUltimaAlteracao = cargoDataUltimaAlteracao;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffCargosHistorico> getCsbffCargosHistoricoList() {
        return csbffCargosHistoricoList;
    }

    public void setCsbffCargosHistoricoList(List<CsbffCargosHistorico> csbffCargosHistoricoList) {
        this.csbffCargosHistoricoList = csbffCargosHistoricoList;
    }

    public CsbffTiposDeCargos getTipoCargoCodCsbffTiposDeCargos() {
        return tipoCargoCodCsbffTiposDeCargos;
    }

    public void setTipoCargoCodCsbffTiposDeCargos(CsbffTiposDeCargos tipoCargoCodCsbffTiposDeCargos) {
        this.tipoCargoCodCsbffTiposDeCargos = tipoCargoCodCsbffTiposDeCargos;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecVaga_1> getRecVagaList() {
        return recVagaList;
    }

    public void setRecVagaList(List<RecVaga_1> recVagaList) {
        this.recVagaList = recVagaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecPessoa_1> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa_1> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargoCodigo != null ? cargoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffCargos)) {
            return false;
        }
        CsbffCargos other = (CsbffCargos) object;
        if ((this.cargoCodigo == null && other.cargoCodigo != null) || (this.cargoCodigo != null && !this.cargoCodigo.equals(other.cargoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffCargos[ cargoCodigo=" + cargoCodigo + " ]";
    }
    
}
