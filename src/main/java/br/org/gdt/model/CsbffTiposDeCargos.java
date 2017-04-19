/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "csbff_tipos_de_cargos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffTiposDeCargos.findAll", query = "SELECT c FROM CsbffTiposDeCargos c")})
public class CsbffTiposDeCargos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_cargo_cod")
    private BigDecimal tipoCargoCod;
    @Basic(optional = false)
    @Column(name = "tipo_cargo_descricao")
    private String tipoCargoDescricao;
    @OneToMany(mappedBy = "tipoCargoCodCsbffTiposDeCargos")
    private List<CsbffCargos> csbffCargosList;

    public CsbffTiposDeCargos() {
    }

    public CsbffTiposDeCargos(BigDecimal tipoCargoCod) {
        this.tipoCargoCod = tipoCargoCod;
    }

    public CsbffTiposDeCargos(BigDecimal tipoCargoCod, String tipoCargoDescricao) {
        this.tipoCargoCod = tipoCargoCod;
        this.tipoCargoDescricao = tipoCargoDescricao;
    }

    public BigDecimal getTipoCargoCod() {
        return tipoCargoCod;
    }

    public void setTipoCargoCod(BigDecimal tipoCargoCod) {
        this.tipoCargoCod = tipoCargoCod;
    }

    public String getTipoCargoDescricao() {
        return tipoCargoDescricao;
    }

    public void setTipoCargoDescricao(String tipoCargoDescricao) {
        this.tipoCargoDescricao = tipoCargoDescricao;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffCargos> getCsbffCargosList() {
        return csbffCargosList;
    }

    public void setCsbffCargosList(List<CsbffCargos> csbffCargosList) {
        this.csbffCargosList = csbffCargosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCargoCod != null ? tipoCargoCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffTiposDeCargos)) {
            return false;
        }
        CsbffTiposDeCargos other = (CsbffTiposDeCargos) object;
        if ((this.tipoCargoCod == null && other.tipoCargoCod != null) || (this.tipoCargoCod != null && !this.tipoCargoCod.equals(other.tipoCargoCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffTiposDeCargos[ tipoCargoCod=" + tipoCargoCod + " ]";
    }
    
}
