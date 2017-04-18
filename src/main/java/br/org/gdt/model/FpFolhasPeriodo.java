/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.modelOld.FpPeriodo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "fp_folhas_periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpFolhasPeriodo.findAll", query = "SELECT f FROM FpFolhasPeriodo f")})
public class FpFolhasPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "flp_id")
    private Integer flpId;
    @OneToMany(mappedBy = "flpIdFpFolhasPeriodo")
    private List<FpFolhasPeriodoEventos> fpFolhasPeriodoEventosList;
    @JoinColumn(name = "per_id_fp_periodo", referencedColumnName = "per_id")
    @ManyToOne
    private FpPeriodo perIdFpPeriodo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public FpFolhasPeriodo() {
    }

    public FpFolhasPeriodo(Integer flpId) {
        this.flpId = flpId;
    }

    public Integer getFlpId() {
        return flpId;
    }

    public void setFlpId(Integer flpId) {
        this.flpId = flpId;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpFolhasPeriodoEventos> getFpFolhasPeriodoEventosList() {
        return fpFolhasPeriodoEventosList;
    }

    public void setFpFolhasPeriodoEventosList(List<FpFolhasPeriodoEventos> fpFolhasPeriodoEventosList) {
        this.fpFolhasPeriodoEventosList = fpFolhasPeriodoEventosList;
    }

    public FpPeriodo getPerIdFpPeriodo() {
        return perIdFpPeriodo;
    }

    public void setPerIdFpPeriodo(FpPeriodo perIdFpPeriodo) {
        this.perIdFpPeriodo = perIdFpPeriodo;
    }

    public RecPessoa_1 getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa_1 recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flpId != null ? flpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpFolhasPeriodo)) {
            return false;
        }
        FpFolhasPeriodo other = (FpFolhasPeriodo) object;
        if ((this.flpId == null && other.flpId != null) || (this.flpId != null && !this.flpId.equals(other.flpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.FpFolhasPeriodo[ flpId=" + flpId + " ]";
    }
    
}
