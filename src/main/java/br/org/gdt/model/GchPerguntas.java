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
@Table(name = "gch_perguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchPerguntas.findAll", query = "SELECT g FROM GchPerguntas g")})
public class GchPerguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "per_codigo")
    private Long perCodigo;
    @Basic(optional = false)
    @Column(name = "per_descricao")
    private long perDescricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perCodigo")
    private List<GchAlternativasperguntas> gchAlternativasperguntasList;

    public GchPerguntas() {
    }

    public GchPerguntas(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public GchPerguntas(Long perCodigo, long perDescricao) {
        this.perCodigo = perCodigo;
        this.perDescricao = perDescricao;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public long getPerDescricao() {
        return perDescricao;
    }

    public void setPerDescricao(long perDescricao) {
        this.perDescricao = perDescricao;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchAlternativasperguntas> getGchAlternativasperguntasList() {
        return gchAlternativasperguntasList;
    }

    public void setGchAlternativasperguntasList(List<GchAlternativasperguntas> gchAlternativasperguntasList) {
        this.gchAlternativasperguntasList = gchAlternativasperguntasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigo != null ? perCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchPerguntas)) {
            return false;
        }
        GchPerguntas other = (GchPerguntas) object;
        if ((this.perCodigo == null && other.perCodigo != null) || (this.perCodigo != null && !this.perCodigo.equals(other.perCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchPerguntas[ perCodigo=" + perCodigo + " ]";
    }
    
}
