/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.modelOld.FpEvento_old;
import br.org.gdt.modelOld.FpPeriodo;
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
@Table(name = "fp_eventos_variaveis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FpEventosVariaveis.findAll", query = "SELECT f FROM FpEventosVariaveis f")})
public class FpEventosVariaveis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "evv_id")
    private Integer evvId;
    @JoinColumn(name = "eve_id_fp_evento", referencedColumnName = "eve_id")
    @ManyToOne
    private FpEvento_old eveIdFpEvento;
    @JoinColumn(name = "per_id_fp_periodo", referencedColumnName = "per_id")
    @ManyToOne
    private FpPeriodo perIdFpPeriodo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;

    public FpEventosVariaveis() {
    }

    public FpEventosVariaveis(Integer evvId) {
        this.evvId = evvId;
    }

    public Integer getEvvId() {
        return evvId;
    }

    public void setEvvId(Integer evvId) {
        this.evvId = evvId;
    }

    public FpEvento_old getEveIdFpEvento() {
        return eveIdFpEvento;
    }

    public void setEveIdFpEvento(FpEvento_old eveIdFpEvento) {
        this.eveIdFpEvento = eveIdFpEvento;
    }

    public FpPeriodo getPerIdFpPeriodo() {
        return perIdFpPeriodo;
    }

    public void setPerIdFpPeriodo(FpPeriodo perIdFpPeriodo) {
        this.perIdFpPeriodo = perIdFpPeriodo;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evvId != null ? evvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpEventosVariaveis)) {
            return false;
        }
        FpEventosVariaveis other = (FpEventosVariaveis) object;
        if ((this.evvId == null && other.evvId != null) || (this.evvId != null && !this.evvId.equals(other.evvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.FpEventosVariaveis[ evvId=" + evvId + " ]";
    }
    
}
