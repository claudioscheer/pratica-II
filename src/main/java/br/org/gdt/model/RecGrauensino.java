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
@Table(name = "rec_grauensino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecGrauensino.findAll", query = "SELECT r FROM RecGrauensino r")})
public class RecGrauensino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idgrauensino")
    private Integer recIdgrauensino;
    @Column(name = "rec_grauensinotipo")
    private Integer recGrauensinotipo;
    @Column(name = "rec_situacao")
    private Integer recSituacao;
    @Column(name = "rec_instituicao")
    private String recInstituicao;
    @Column(name = "rec_anoinicio")
    private String recAnoinicio;
    @Column(name = "rec_anoconclusao")
    private String recAnoconclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdgrauensino")
    private List<RecVaga> recVagaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdgrauensino")
    private List<RecPessoa> recPessoaList;

    public RecGrauensino() {
    }

    public RecGrauensino(Integer recIdgrauensino) {
        this.recIdgrauensino = recIdgrauensino;
    }

    public Integer getRecIdgrauensino() {
        return recIdgrauensino;
    }

    public void setRecIdgrauensino(Integer recIdgrauensino) {
        this.recIdgrauensino = recIdgrauensino;
    }

    public Integer getRecGrauensinotipo() {
        return recGrauensinotipo;
    }

    public void setRecGrauensinotipo(Integer recGrauensinotipo) {
        this.recGrauensinotipo = recGrauensinotipo;
    }

    public Integer getRecSituacao() {
        return recSituacao;
    }

    public void setRecSituacao(Integer recSituacao) {
        this.recSituacao = recSituacao;
    }

    public String getRecInstituicao() {
        return recInstituicao;
    }

    public void setRecInstituicao(String recInstituicao) {
        this.recInstituicao = recInstituicao;
    }

    public String getRecAnoinicio() {
        return recAnoinicio;
    }

    public void setRecAnoinicio(String recAnoinicio) {
        this.recAnoinicio = recAnoinicio;
    }

    public String getRecAnoconclusao() {
        return recAnoconclusao;
    }

    public void setRecAnoconclusao(String recAnoconclusao) {
        this.recAnoconclusao = recAnoconclusao;
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
        hash += (recIdgrauensino != null ? recIdgrauensino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecGrauensino)) {
            return false;
        }
        RecGrauensino other = (RecGrauensino) object;
        if ((this.recIdgrauensino == null && other.recIdgrauensino != null) || (this.recIdgrauensino != null && !this.recIdgrauensino.equals(other.recIdgrauensino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.RecGrauensino[ recIdgrauensino=" + recIdgrauensino + " ]";
    }
    
}
