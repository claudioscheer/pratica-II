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
@SequenceGenerator(name = "seq_gch_alt", sequenceName = "seq_gch_alt", allocationSize = 1)
public class GchAlternativas implements Serializable,SampleEntity {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_alt")
    @Basic(optional = false)
    @Column(name = "alt_codigo")
    private long altCodigo;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy="per_codigo")
    private List<GchPerguntas> gchPerguntasList;

    public void setGchRespostasList(List<GchRespostas> gchRespostasList) {
        this.gchRespostasList = gchRespostasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.altCodigo ^ (this.altCodigo >>> 32));
        hash = 67 * hash + Objects.hashCode(this.altDescricao);
        hash = 67 * hash + this.altPrioridade;
        hash = 67 * hash + Objects.hashCode(this.gchAlternativasperguntas);
        hash = 67 * hash + Objects.hashCode(this.gchRespostasList);
        hash = 67 * hash + Objects.hashCode(this.gchPerguntasList);
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
        if (!Objects.equals(this.gchPerguntasList, other.gchPerguntasList)) {
            return false;
        }
        return true;
    }

    public List<GchPerguntas> getGchPerguntasList() {
        return gchPerguntasList;
    }

    public void setGchPerguntasList(List<GchPerguntas> gchPerguntasList) {
        this.gchPerguntasList = gchPerguntasList;
    }
    
    public GchAlternativas() {
    }



    @XmlTransient
    @JsonIgnore
    public List<GchRespostas> getGchRespostasList() {
        return gchRespostasList;
    }



    @Override
    public Long getId() {
      
        return Long.valueOf(altCodigo);
    }

    public long getAltCodigo() {
        return altCodigo;
    }

    public void setAltCodigo(long altCodigo) {
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
    
}
