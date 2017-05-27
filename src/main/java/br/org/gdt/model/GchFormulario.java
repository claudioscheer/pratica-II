/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alisson Allebrandt
 */





@Entity
@Table(name = "gch_formulario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchFormulario.findAll", query = "SELECT g FROM GchFormulario g")})
@SequenceGenerator(name = "seq_gch_form", sequenceName = "seq_gch_form", allocationSize = 1)

public class GchFormulario
implements Serializable {
    @OneToMany(mappedBy = "formulario")
    private List<GchFormularioPessoa> gchFormularioPessoas;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_form")
    @Basic(optional = false)
    @Column(name = "form_codigo")
    private long formCodigo;
    @Basic(optional = false)
    @Column(name = "form_nome")
    private String formNome;
    @Basic(optional = false)
    @Column(name = "form_descricao")
    private String formDescricao;
    @Basic(optional = false)
    @Column(name = "form_prazoResposta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date formPrazoResposta;

    @OneToMany(mappedBy = "formulario", cascade = CascadeType.REMOVE)
    private List<GchPerguntas> perguntas;

    public List<GchFormularioPessoa> getGchFormularioPessoas() {
        return gchFormularioPessoas;
    }

    public void setGchFormularioPessoas(List<GchFormularioPessoa> gchFormularioPessoas) {
        this.gchFormularioPessoas = gchFormularioPessoas;
    }
    
    
    
    
    public long getFormCodigo() {
        return formCodigo;
    }

    public void setFormCodigo(long formCodigo) {
        this.formCodigo = formCodigo;
    }

    public String getFormNome() {
        return formNome;
    }

    public void setFormNome(String formNome) {
        this.formNome = formNome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.formCodigo ^ (this.formCodigo >>> 32));
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
        final GchFormulario other = (GchFormulario) obj;
        if (this.formCodigo != other.formCodigo) {
            return false;
        }
        return true;
    }

   

    public String getFormDescricao() {
        return formDescricao;
    }

    public void setFormDescricao(String formDescricao) {
        this.formDescricao = formDescricao;
    }

    public Date getFormPrazoResposta() {
        return formPrazoResposta;
    }

    public void setFormPrazoResposta(Date formPrazoResposta) {
        this.formPrazoResposta = formPrazoResposta;
    }

    public void addPergunta(GchPerguntas gchPergunta) {
        if (gchPergunta != null) {
          
            this.getPerguntas().add(gchPergunta);
        }
    };

    
    public List<GchPerguntas> getPerguntas() {

        if (this.perguntas == null) {
            this.perguntas = new ArrayList<>();
        }

        return perguntas;
    }

    public void setPerguntas(List<GchPerguntas> perguntas) {
        this.perguntas = perguntas;
    }

}
