/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;




@Entity
@SequenceGenerator(name = "seq_csbff_cargo", sequenceName = "seq_csbff_cargo", allocationSize = 1)
@Table(name = "csbff_cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffCargos.findAll", query = "SELECT c FROM CsbffCargos c")})
public class CsbffCargos implements Serializable,SampleEntity {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_csbff_cargo")
    @Basic(optional = false)
    @Id
    @Column(name = "cargo_codigo")
    private long cargoCodigo;
    @Basic(optional = false)
    @Column(name = "cargo_nome")
    private String cargoNome;
    @Basic(optional = false)
    @Column(name = "cargo_cbo")
    private long cargoCbo;
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
    @OneToMany(mappedBy = "cargoCodigo")
    private List<CsbffCargosHistorico> csbffCargosHistoricoList;
    @JoinColumn(name = "tipo_cargo_cod_csbff_tipos_de_cargos", referencedColumnName = "tipo_cargo_cod")
    @ManyToOne
    private CsbffTiposDeCargos tipoCargoCodCsbffTiposDeCargos;
    @OneToMany(mappedBy = "cargoCodigo")
    private List<RecVaga> recVagaList;
    @OneToMany(mappedBy = "cargoCodigo")
    private List<RecPessoa> recPessoaList;

    public CsbffCargos() {
    }

    public CsbffCargos(long cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public CsbffCargos(long cargoCodigo, String cargoNome, long cargoCbo, Date cargoDataDeCriacao) {
        this.cargoCodigo = cargoCodigo;
        this.cargoNome = cargoNome;
        this.cargoCbo = cargoCbo;
        this.cargoDataDeCriacao = cargoDataDeCriacao;
    }

    public long getCargoCodigo() {
        return cargoCodigo;
    }

    public void setCargoCodigo(long cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public long getCargoCbo() {
        return cargoCbo;
    }

    public void setCargoCbo(long cargoCbo) {
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
    public List<RecVaga> getRecVagaList() {
        return recVagaList;
    }

    public void setRecVagaList(List<RecVaga> recVagaList) {
        this.recVagaList = recVagaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecPessoa> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.cargoCodigo ^ (this.cargoCodigo >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CsbffCargos other = (CsbffCargos) obj;
        if (this.cargoCodigo != other.cargoCodigo) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
//        return "br.org.gdt.modelNew.CsbffCargos[ cargoCodigo=" + cargoCodigo + " ]";
return cargoNome;
    }
    
    @Override
    public Long getId(){
       return Long.valueOf(this.cargoCodigo);
        
    }
    
    
}
