/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_alternativas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchAlternativas.findAll", query = "SELECT g FROM GchAlternativas g")})
@SequenceGenerator(name = "seq_gch_alt", sequenceName = "seq_gch_alt", allocationSize = 1)
public class GchAlternativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_alt")
    @Column(name = "alt_codigo")
    private long altCodigo;
    @Basic(optional = false)
    @Column(name = "alt_descricao")
    private String altDescricao;
    @Basic(optional = false)
    @Column(name = "alt_prioridade")
    private short altPrioridade;
    @ManyToOne
    private GchAlternativasperguntas gchAlternativasperguntas;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<GchRespostas> gchRespostasList;

    @Transient //Isso diz que a coluna nao deve ser criada no banco, então não pode remover
    private long perCodigo;
    
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

    public void setAltCodigo(long altCodigo) {
        this.altCodigo = altCodigo;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchAlternativas[ altCodigo=" + altCodigo + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.altCodigo ^ (this.altCodigo >>> 32));
        hash = 97 * hash + Objects.hashCode(this.altDescricao);
        hash = 97 * hash + this.altPrioridade;
        hash = 97 * hash + Objects.hashCode(this.gchAlternativasperguntas);
        hash = 97 * hash + Objects.hashCode(this.gchRespostasList);
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
        final GchAlternativas other = (GchAlternativas) obj;
        if (this.altCodigo != other.altCodigo) {
            return false;
        }
        if (!Objects.equals(this.altDescricao, other.altDescricao)) {
            return false;
        }
        if (this.altPrioridade != other.altPrioridade) {
            return false;
        }
        if (!Objects.equals(this.gchAlternativasperguntas, other.gchAlternativasperguntas)) {
            return false;
        }
        if (!Objects.equals(this.gchRespostasList, other.gchRespostasList)) {
            return false;
        }
        return true;
    }

    public long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(long perCodigo) {
        this.perCodigo = perCodigo;
    }


    
}
