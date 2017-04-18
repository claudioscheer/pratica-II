/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "csbff_cargos_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffCargosHistorico.findAll", query = "SELECT c FROM CsbffCargosHistorico c")})
public class CsbffCargosHistorico implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "cargo_historico_codigo")
    private BigDecimal cargoHistoricoCodigo;
    @Basic(optional = false)
    @Column(name = "cargo_historico_descricao")
    private String cargoHistoricoDescricao;
    @JoinColumn(name = "cargo_codigo", referencedColumnName = "cargo_codigo")
    @ManyToOne(optional = false)
    private CsbffCargos cargoCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public CsbffCargosHistorico() {
    }

    public CsbffCargosHistorico(BigDecimal cargoHistoricoCodigo) {
        this.cargoHistoricoCodigo = cargoHistoricoCodigo;
    }

    public CsbffCargosHistorico(BigDecimal cargoHistoricoCodigo, String cargoHistoricoDescricao) {
        this.cargoHistoricoCodigo = cargoHistoricoCodigo;
        this.cargoHistoricoDescricao = cargoHistoricoDescricao;
    }

    public BigDecimal getCargoHistoricoCodigo() {
        return cargoHistoricoCodigo;
    }

    public void setCargoHistoricoCodigo(BigDecimal cargoHistoricoCodigo) {
        this.cargoHistoricoCodigo = cargoHistoricoCodigo;
    }

    public String getCargoHistoricoDescricao() {
        return cargoHistoricoDescricao;
    }

    public void setCargoHistoricoDescricao(String cargoHistoricoDescricao) {
        this.cargoHistoricoDescricao = cargoHistoricoDescricao;
    }

    public CsbffCargos getCargoCodigo() {
        return cargoCodigo;
    }

    public void setCargoCodigo(CsbffCargos cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
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
        hash += (cargoHistoricoCodigo != null ? cargoHistoricoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffCargosHistorico)) {
            return false;
        }
        CsbffCargosHistorico other = (CsbffCargosHistorico) object;
        if ((this.cargoHistoricoCodigo == null && other.cargoHistoricoCodigo != null) || (this.cargoHistoricoCodigo != null && !this.cargoHistoricoCodigo.equals(other.cargoHistoricoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffCargosHistorico[ cargoHistoricoCodigo=" + cargoHistoricoCodigo + " ]";
    }
    
}
