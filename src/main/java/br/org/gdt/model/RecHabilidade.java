/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@SequenceGenerator(name = "seq_RecHabilidade", sequenceName = "seq_RecHabilidade", allocationSize = 1)
public class RecHabilidade implements Serializable,SampleEntity {
    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.recIdhabilidade ^ (this.recIdhabilidade >>> 32));
        return hash;
    }

    public void setRecIdhabilidade(long recIdhabilidade) {
        this.recIdhabilidade = recIdhabilidade;
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
        final RecHabilidade other = (RecHabilidade) obj;
        if (this.recIdhabilidade != other.recIdhabilidade) {
            return false;
        }
        return true;
    }
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idhabilidade")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_RecHabilidade")
    private long recIdhabilidade;
    @Column(name = "rec_descricao")
    private String recDescricao;
    @Column(name = "rec_habilidadenivel")
    private Integer recHabilidadenivel;       
    @ManyToMany(mappedBy = "recHabilidadeList")
    private List<RecVaga> recVagaList;    
    
    @ManyToMany(mappedBy = "recHabilidadeList")
    private List<RecPessoa> recPessoaList;

    public RecHabilidade() {
    }

    public RecHabilidade(long recIdhabilidade) {
        this.recIdhabilidade = recIdhabilidade;
    }

    public long getRecIdhabilidade() {
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

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (recIdhabilidade != null ? recIdhabilidade.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof RecHabilidade)) {
//            return false;
//        }
//        RecHabilidade other = (RecHabilidade) object;
////        if ((this.recIdhabilidade == null && other.recIdhabilidade != null) || (this.recIdhabilidade != null && !this.recIdhabilidade.equals(other.recIdhabilidade))) {
//            return false;
//        }
//        return true;
//    }

    //@Override
    //public String toString() {
      //  return "br.org.gdt.modelNew.RecHabilidade[ recIdhabilidade=" + recIdhabilidade + " ]";
    //}

    @Override
    public Long getId()
    {
        return this.recIdhabilidade;
    }
    
}
