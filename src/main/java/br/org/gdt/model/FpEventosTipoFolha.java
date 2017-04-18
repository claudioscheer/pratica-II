/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.modelOld.FpEvento;
import br.org.gdt.modelOld.FpTipoFolha;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "fp_eventos_tipo_folha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpEventosTipoFolha.findAll", query = "SELECT f FROM FpEventosTipoFolha f")})
public class FpEventosTipoFolha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "etf_id")
    private Integer etfId;
    @JoinColumn(name = "eve_id_fp_evento", referencedColumnName = "eve_id")
    @ManyToOne
    private FpEvento eveIdFpEvento;
    @JoinColumn(name = "tpf_id_fp_tipo_folha", referencedColumnName = "tpf_id")
    @ManyToOne
    private FpTipoFolha tpfIdFpTipoFolha;

    public FpEventosTipoFolha() {
    }

    public FpEventosTipoFolha(Integer etfId) {
        this.etfId = etfId;
    }

    public Integer getEtfId() {
        return etfId;
    }

    public void setEtfId(Integer etfId) {
        this.etfId = etfId;
    }

    public FpEvento getEveIdFpEvento() {
        return eveIdFpEvento;
    }

    public void setEveIdFpEvento(FpEvento eveIdFpEvento) {
        this.eveIdFpEvento = eveIdFpEvento;
    }

    public FpTipoFolha getTpfIdFpTipoFolha() {
        return tpfIdFpTipoFolha;
    }

    public void setTpfIdFpTipoFolha(FpTipoFolha tpfIdFpTipoFolha) {
        this.tpfIdFpTipoFolha = tpfIdFpTipoFolha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etfId != null ? etfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpEventosTipoFolha)) {
            return false;
        }
        FpEventosTipoFolha other = (FpEventosTipoFolha) object;
        if ((this.etfId == null && other.etfId != null) || (this.etfId != null && !this.etfId.equals(other.etfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.FpEventosTipoFolha[ etfId=" + etfId + " ]";
    }
    
}
