/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchMunicipios.findAll", query = "SELECT g FROM GchMunicipios g")})
public class GchMunicipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mun_codigo")
    private Long munCodigo;
    @Basic(optional = false)
    @Column(name = "mun_descricao")
    private long munDescricao;
    @Column(name = "mun_cep")
    private Integer munCep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munCodigo")
    private List<GchTreinamentos> gchTreinamentosList;
    @JoinColumn(name = "uf_codigo", referencedColumnName = "uf_codigo")
    @ManyToOne(optional = false)
    private GchUfs ufCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munCodigo")
    private List<RecPessoa_1> recPessoaList;

    public GchMunicipios() {
    }

    public GchMunicipios(Long munCodigo) {
        this.munCodigo = munCodigo;
    }

    public GchMunicipios(Long munCodigo, long munDescricao) {
        this.munCodigo = munCodigo;
        this.munDescricao = munDescricao;
    }

    public Long getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(Long munCodigo) {
        this.munCodigo = munCodigo;
    }

    public long getMunDescricao() {
        return munDescricao;
    }

    public void setMunDescricao(long munDescricao) {
        this.munDescricao = munDescricao;
    }

    public Integer getMunCep() {
        return munCep;
    }

    public void setMunCep(Integer munCep) {
        this.munCep = munCep;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchTreinamentos> getGchTreinamentosList() {
        return gchTreinamentosList;
    }

    public void setGchTreinamentosList(List<GchTreinamentos> gchTreinamentosList) {
        this.gchTreinamentosList = gchTreinamentosList;
    }

    public GchUfs getUfCodigo() {
        return ufCodigo;
    }

    public void setUfCodigo(GchUfs ufCodigo) {
        this.ufCodigo = ufCodigo;
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
        hash += (munCodigo != null ? munCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchMunicipios)) {
            return false;
        }
        GchMunicipios other = (GchMunicipios) object;
        if ((this.munCodigo == null && other.munCodigo != null) || (this.munCodigo != null && !this.munCodigo.equals(other.munCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchMunicipios[ munCodigo=" + munCodigo + " ]";
    }
    
}
