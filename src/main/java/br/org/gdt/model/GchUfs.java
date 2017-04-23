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
@Table(name = "gch_ufs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchUfs.findAll", query = "SELECT g FROM GchUfs g")})
public class GchUfs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uf_codigo")
    private Long ufCodigo;
    @Basic(optional = false)
    @Column(name = "uf_sigla")
    private String ufSigla;
    @Basic(optional = false)
    @Column(name = "uf_nome")
    private String ufNome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ufCodigo")
    private List<GchMunicipios> gchMunicipiosList;

    public GchUfs() {
    }

    public GchUfs(Long ufCodigo) {
        this.ufCodigo = ufCodigo;
    }

    public GchUfs(Long ufCodigo, String ufSigla, String ufNome) {
        this.ufCodigo = ufCodigo;
        this.ufSigla = ufSigla;
        this.ufNome = ufNome;
    }

    public Long getUfCodigo() {
        return ufCodigo;
    }

    public void setUfCodigo(Long ufCodigo) {
        this.ufCodigo = ufCodigo;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    public String getUfNome() {
        return ufNome;
    }

    public void setUfNome(String ufNome) {
        this.ufNome = ufNome;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchMunicipios> getGchMunicipiosList() {
        return gchMunicipiosList;
    }

    public void setGchMunicipiosList(List<GchMunicipios> gchMunicipiosList) {
        this.gchMunicipiosList = gchMunicipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ufCodigo != null ? ufCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchUfs)) {
            return false;
        }
        GchUfs other = (GchUfs) object;
        if ((this.ufCodigo == null && other.ufCodigo != null) || (this.ufCodigo != null && !this.ufCodigo.equals(other.ufCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchUfs[ ufCodigo=" + ufCodigo + " ]";
    }
    
}
