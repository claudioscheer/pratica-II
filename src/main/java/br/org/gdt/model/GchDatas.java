/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "gch_datas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchDatas.findAll", query = "SELECT g FROM GchDatas g")})
public class GchDatas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "data_codigo")
    private Long dataCodigo;
    @Basic(optional = false)
    @Column(name = "data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicio;
    @Basic(optional = false)
    @Column(name = "data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;
    @JoinColumn(name = "trei_codigo", referencedColumnName = "trei_codigo")
    @ManyToOne(optional = false)
    private GchTreinamentos treiCodigo;

    public GchDatas() {
    }

    public GchDatas(Long dataCodigo) {
        this.dataCodigo = dataCodigo;
    }

    public GchDatas(Long dataCodigo, Date dataInicio, Date dataFim) {
        this.dataCodigo = dataCodigo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getDataCodigo() {
        return dataCodigo;
    }

    public void setDataCodigo(Long dataCodigo) {
        this.dataCodigo = dataCodigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public GchTreinamentos getTreiCodigo() {
        return treiCodigo;
    }

    public void setTreiCodigo(GchTreinamentos treiCodigo) {
        this.treiCodigo = treiCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataCodigo != null ? dataCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchDatas)) {
            return false;
        }
        GchDatas other = (GchDatas) object;
        if ((this.dataCodigo == null && other.dataCodigo != null) || (this.dataCodigo != null && !this.dataCodigo.equals(other.dataCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchDatas[ dataCodigo=" + dataCodigo + " ]";
    }
    
}
