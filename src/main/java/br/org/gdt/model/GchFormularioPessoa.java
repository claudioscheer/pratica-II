/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alisson Allebrandt
 */


@Entity
@Table(name = "gch_formularioPessoas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchFormularioPessoa.findAll", query = "SELECT g FROM GchFormularioPessoa g")})
@SequenceGenerator(name = "seq_form_pescodigo", sequenceName = "seq_form_pescodigo", allocationSize = 1)
public class GchFormularioPessoa implements Serializable  {

    @Id
    @Basic(optional = false)
    @Column(name = "form_pescodigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_form_pescodigo")
    private int formPesCodigo;

//    @JoinColumn(name="formId",referencedColumnName = "form_codigo")
    
  
    @ManyToOne
    private GchFormulario formulario;
    
//    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    

    @ManyToOne
    private RecPessoa recIdpessoa;

    @Basic(optional=false)
    @Column(name="respondido")
    private boolean formRespondido;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.formPesCodigo;
        hash = 79 * hash + Objects.hashCode(this.formulario);
        hash = 79 * hash + Objects.hashCode(this.recIdpessoa);
        hash = 79 * hash + (this.formRespondido ? 1 : 0);
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
        final GchFormularioPessoa other = (GchFormularioPessoa) obj;
        if (this.formPesCodigo != other.formPesCodigo) {
            return false;
        }
        if (!Objects.equals(this.formulario, other.formulario)) {
            return false;
        }
        if (!Objects.equals(this.recIdpessoa, other.recIdpessoa)) {
            return false;
        }
        if (this.formRespondido != other.formRespondido) {
            return false;
        }
        return true;
    }
    
    
    public int getFormPesCodigo() {
        return formPesCodigo;
    }

    public void setFormPesCodigo(int formPesCodigo) {
        this.formPesCodigo = formPesCodigo;
    }

    public GchFormulario getFormulario() {
        return formulario;
    }

    public void setFormulario(GchFormulario formulario) {
        this.formulario = formulario;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public boolean isFormRespondido() {
        return formRespondido;
    }

    public void setFormRespondido(boolean formRespondido) {
        this.formRespondido = formRespondido;
    }
    
  
    
}
