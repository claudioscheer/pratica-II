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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_alternativas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchAlternativas.findAll", query = "SELECT g FROM GchAlternativas g")})
public class GchAlternativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alt_codigo")
    private Long altCodigo;
    @Basic(optional = false)
    @Column(name = "alt_descricao")
    private String altDescricao;
    @Basic(optional = false)
    @Column(name = "alt_prioridade")
    private short altPrioridade;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "gchAlternativas")
    private GchAlternativasperguntas gchAlternativasperguntas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "altCodigo")
    private List<GchRespostas> gchRespostasList;

    public GchAlternativas() {
    }

    public GchAlternativas(Long altCodigo) {
        this.altCodigo = altCodigo;
    }

    public GchAlternativas(Long altCodigo, String altDescricao, short altPrioridade) {
        this.altCodigo = altCodigo;
        this.altDescricao = altDescricao;
        this.altPrioridade = altPrioridade;
    }

    public Long getAltCodigo() {
        return altCodigo;
    }

    public void setAltCodigo(Long altCodigo) {
        this.altCodigo = altCodigo;
    }

    public String getAltDescricao() {
        return altDescricao;
    }

    public void setAltDescricao(String altDescricao) {
        this.altDescricao = altDescricao;
    }

    public short getAltPrioridade() {
        return altPrioridade;
    }

    public void setAltPrioridade(short altPrioridade) {
        this.altPrioridade = altPrioridade;
    }

    public GchAlternativasperguntas getGchAlternativasperguntas() {
        return gchAlternativasperguntas;
    }

    public void setGchAlternativasperguntas(GchAlternativasperguntas gchAlternativasperguntas) {
        this.gchAlternativasperguntas = gchAlternativasperguntas;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchRespostas> getGchRespostasList() {
        return gchRespostasList;
    }

    public void setGchRespostasList(List<GchRespostas> gchRespostasList) {
        this.gchRespostasList = gchRespostasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (altCodigo != null ? altCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchAlternativas)) {
            return false;
        }
        GchAlternativas other = (GchAlternativas) object;
        if ((this.altCodigo == null && other.altCodigo != null) || (this.altCodigo != null && !this.altCodigo.equals(other.altCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchAlternativas[ altCodigo=" + altCodigo + " ]";
    }
    
}
