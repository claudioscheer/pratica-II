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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_alternativasperguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchAlternativasperguntas.findAll", query = "SELECT g FROM GchAlternativasperguntas g")})
@SequenceGenerator(name = "seq_gch_alt", sequenceName = "seq_gch_alt", allocationSize = 1)
public class GchAlternativasperguntas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id    
    @Basic(optional = false)
    @Column(name = "alt_perCodigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gch_alt")
    private long altPerCodigo;

    

    @ManyToOne
    private GchAlternativas gchAlternativas;
   
    @ManyToOne(cascade = CascadeType.REMOVE)
    private GchPerguntas perCodigo;

    
    public long getAltPerCodigo() {
        return altPerCodigo;
    }

    public void setAltPerCodigo(long altPerCodigo) {
        this.altPerCodigo = altPerCodigo;
    }
    
    public GchAlternativasperguntas() {
    }

   

    public GchAlternativas getGchAlternativas() {
        return gchAlternativas;
    }

    public void setGchAlternativas(GchAlternativas gchAlternativas) {
        this.gchAlternativas = gchAlternativas;
    }

    public GchPerguntas getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(GchPerguntas perCodigo) {
        this.perCodigo = perCodigo;
    }

   @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.altPerCodigo ^ (this.altPerCodigo >>> 32));
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
        final GchAlternativasperguntas other = (GchAlternativasperguntas) obj;
        if (this.altPerCodigo != other.altPerCodigo) {
            return false;
        }
        return true;
    }
  
}
