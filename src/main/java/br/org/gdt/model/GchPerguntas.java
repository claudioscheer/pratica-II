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
import javax.persistence.EmbeddedId;
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
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_perguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchPerguntas.findAll", query = "SELECT g FROM GchPerguntas g")})
@SequenceGenerator(name = "seq_gch_per", sequenceName = "seq_gch_per", allocationSize = 1)
public class GchPerguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_per")
    @Basic(optional = false)
    @Column(name = "per_codigo")
    private long perCodigo;
    @Basic(optional = false)
    @Column(name = "per_descricao")
    private String perDescricao;
   
    @OneToMany
    private List<GchAlternativas> gchAlternativas;
    
    @JoinColumn(name = "form_codigo", referencedColumnName = "form_codigo")
    @ManyToOne(cascade = CascadeType.REMOVE)
    private GchFormulario formulario;
    @OneToMany(mappedBy = "perCodigo",cascade =  CascadeType.REMOVE)
    private List<GchAlternativasperguntas> gchAlternativasperguntass;

    public List<GchAlternativasperguntas> getGchAlternativasperguntass() {
        return gchAlternativasperguntass;
    }

    public void setGchAlternativasperguntass(List<GchAlternativasperguntas> gchAlternativasperguntass) {
        this.gchAlternativasperguntass = gchAlternativasperguntass;
    }

    public GchFormulario getFormulario() {
        return formulario;
    }

    public void setFormulario(GchFormulario formulario) {
        this.formulario = formulario;
    }
    
    
    public GchPerguntas() {
    }

    public long getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerDescricao() {
        return perDescricao;
    }

    public void setPerDescricao(String perDescricao) {
        this.perDescricao = perDescricao;
    }

    public List<GchAlternativas> getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(List<GchAlternativas> gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.perCodigo ^ (this.perCodigo >>> 32));
        hash = 79 * hash + Objects.hashCode(this.perDescricao);
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
        final GchPerguntas other = (GchPerguntas) obj;
        if (this.perCodigo != other.perCodigo) {
            return false;
        }
        if (!Objects.equals(this.perDescricao, other.perDescricao)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return this.perDescricao;
    }

    public GchPerguntas(long perCodigo) {
        this.perCodigo = perCodigo;
    }

   
    
}
