/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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

public class GchMunicipios implements Serializable, SampleEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)    
    @Column(name = "mun_codigo")
    private Long munCodigo;
    @Basic(optional = false)
    @Column(name = "mun_descricao")
    private String munDescricao;
    @Column(name = "mun_cep")
    private Integer munCep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munCodigo")
    private List<GchTreinamentos> gchTreinamentosList;
    @JoinColumn(name = "uf_codigo", referencedColumnName = "uf_codigo")
    @ManyToOne(optional = false)
    private GchUfs ufCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munCodigo")
    private List<RecPessoa> recPessoaList;

    public GchMunicipios() {
    }

    public GchMunicipios(Long munCodigo) {
        this.munCodigo = munCodigo;
    }

    public GchMunicipios(Long munCodigo, String munDescricao) {
        this.munCodigo = munCodigo;
        this.munDescricao = munDescricao;
    }

    public Long getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(Long munCodigo) {
        this.munCodigo = munCodigo;
    }

    public String getMunDescricao() {
        return munDescricao;
    }

    public void setMunDescricao(String munDescricao) {
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
    public List<RecPessoa> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.munCodigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GchMunicipios other = (GchMunicipios) obj;
        if (!Objects.equals(this.munCodigo, other.munCodigo)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "br.org.gdt.model.GchMunicipios[ munCodigo=" + munCodigo + " ]";
    }

    @Override
    public Long getId() {
       return Long.reverse(munCodigo);
    }
    
    
}
