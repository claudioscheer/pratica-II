/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "rec_habilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecHabilidade.findAll", query = "SELECT r FROM RecHabilidade r")})
public class RecHabilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idhabilidade")
    private Integer recIdhabilidade;
    @Column(name = "rec_descricao")
    private String recDescricao;
    @Column(name = "rec_habilidadenivel")
    private Integer recHabilidadenivel;
    @JoinTable(name = "rec_vaga_habilidade", joinColumns = {
        @JoinColumn(name = "rec_idhabilidade", referencedColumnName = "rec_idhabilidade")}, inverseJoinColumns = {
        @JoinColumn(name = "rec_idvaga", referencedColumnName = "rec_idvaga")})
    @ManyToMany
    private List<RecVaga> recVagaList;
    @JoinTable(name = "rec_pessoa_habilidade", joinColumns = {
        @JoinColumn(name = "rec_idhabilidade", referencedColumnName = "rec_idhabilidade")}, inverseJoinColumns = {
        @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")})
    @ManyToMany
    private List<RecPessoa> recPessoaList;

    public RecHabilidade() {
    }

    public RecHabilidade(Integer recIdhabilidade) {
        this.recIdhabilidade = recIdhabilidade;
    }

    public Integer getRecIdhabilidade() {
        return recIdhabilidade;
    }

    public void setRecIdhabilidade(Integer recIdhabilidade) {
        this.recIdhabilidade = recIdhabilidade;
    }

    public String getRecDescricao() {
        return recDescricao;
    }

    public void setRecDescricao(String recDescricao) {
        this.recDescricao = recDescricao;
    }

    public Integer getRecHabilidadenivel() {
        return recHabilidadenivel;
    }

    public void setRecHabilidadenivel(Integer recHabilidadenivel) {
        this.recHabilidadenivel = recHabilidadenivel;
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
        int hash = 0;
        hash += (recIdhabilidade != null ? recIdhabilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecHabilidade)) {
            return false;
        }
        RecHabilidade other = (RecHabilidade) object;
        if ((this.recIdhabilidade == null && other.recIdhabilidade != null) || (this.recIdhabilidade != null && !this.recIdhabilidade.equals(other.recIdhabilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.RecHabilidade[ recIdhabilidade=" + recIdhabilidade + " ]";
    }
    
}
