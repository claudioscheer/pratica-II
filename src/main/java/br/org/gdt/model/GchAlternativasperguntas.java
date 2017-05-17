/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
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
 * @author Diego
 */
@Entity
@Table(name = "gch_alternativasperguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchAlternativasperguntas.findAll", query = "SELECT g FROM GchAlternativasperguntas g")})
@SequenceGenerator(name = "seq_alt_codigo", sequenceName = "sequencia_alternativas_perguntas", allocationSize = 1)
public class GchAlternativasperguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "per_alt_codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alt_codigo")
    private long perAltCodigo;
    @JoinColumn(name = "alt_codigo", referencedColumnName = "alt_codigo")
//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
       @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private GchAlternativas altCodigo;
    @JoinColumn(name = "per_codigo", referencedColumnName = "per_codigo")
    @ManyToOne(optional = false)
    private GchPerguntas perCodigo;

    public GchAlternativasperguntas() {
    }

    public GchAlternativasperguntas(long perAltCodigo, GchAlternativas altCodigo, GchPerguntas perCodigo) {
        this.perAltCodigo = perAltCodigo;
        this.altCodigo = altCodigo;
        this.perCodigo = perCodigo;
    }

    public long getPerAltCodigo() {
        return perAltCodigo;
    }

    public void setPerAltCodigo(long perAltCodigo) {
        this.perAltCodigo = perAltCodigo;
    }

    public GchAlternativas getAltCodigo() {
        return altCodigo;
    }

    public void setAltCodigo(GchAlternativas altCodigo) {
        this.altCodigo = altCodigo;
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
        hash = 59 * hash + (int) (this.perAltCodigo ^ (this.perAltCodigo >>> 32));
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
        if (this.perAltCodigo != other.perAltCodigo) {
            return false;
        }
        return true;
    }

   

    
}
