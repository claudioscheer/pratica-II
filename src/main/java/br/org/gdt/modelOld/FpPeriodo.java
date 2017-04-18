package br.org.gdt.modelOld;

import br.org.gdt.model.FpEventosVariaveis;
import br.org.gdt.model.FpFolhasPeriodo;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq_fp_periodo", sequenceName = "seq_fp_periodo", allocationSize = 1)
@Table(name = "fp_periodo")
public class FpPeriodo implements java.io.Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @Column(name = "per_datainicial")
    @Temporal(TemporalType.DATE)
    private Date perDatainicial;
    @Basic(optional = false)
    @Column(name = "per_datafinal")
    @Temporal(TemporalType.DATE)
    private Date perDatafinal;
    @Basic(optional = false)
    @Column(name = "per_mes")
    private int perMes;
    @Basic(optional = false)
    @Column(name = "per_ano")
    private int perAno;
    @Basic(optional = false)
    @Column(name = "per_pagamentorealizado")
    private boolean perPagamentorealizado;
    @Basic(optional = false)
    @Column(name = "per_diasuteis")
    private int perDiasuteis;
    @Basic(optional = false)
    @Column(name = "per_diasnaouteis")
    private int perDiasnaouteis;
    @Basic(optional = false)
    @Column(name = "perid")
    private long perid;
    @Basic(optional = false)
    @Column(name = "perano")
    private int perano;
    @Column(name = "perdatafinal")
    @Temporal(TemporalType.DATE)
    private Date perdatafinal;
    @Column(name = "perdatainicial")
    @Temporal(TemporalType.DATE)
    private Date perdatainicial;
    @Basic(optional = false)
    @Column(name = "perdiasuteis")
    private int perdiasuteis;
    @Basic(optional = false)
    @Column(name = "permes")
    private int permes;
    @OneToMany(mappedBy = "perIdFpPeriodo")
    private List<FpEventosVariaveis> fpEventosVariaveisList;
    @OneToMany(mappedBy = "perIdFpPeriodo")
    private List<FpHorasTrabalhadas> fpHorasTrabalhadasList;
    @OneToMany(mappedBy = "perIdFpPeriodo")
    private List<FpFolhasPeriodo> fpFolhasPeriodoList;

    private static final long serialVersionUID = -2790083349568956163L;
    private long perId;
    private int perMes;
    private int perAno;
    private int perDiasUteis;
    private Date perDataInicial;
    private Date perDataFinal;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_periodo")
    public long getPerId() {
        return this.perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }

    public int getPerMes() {
        return perMes;
    }

    public void setPerMes(int perMes) {
        this.perMes = perMes;
    }

    public int getPerAno() {
        return perAno;
    }

    public void setPerAno(int perAno) {
        this.perAno = perAno;
    }

    public int getPerDiasUteis() {
        return perDiasUteis;
    }

    public void setPerDiasUteis(int perDiasUteis) {
        this.perDiasUteis = perDiasUteis;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPerDataInicial() {
        return perDataInicial;
    }

    public void setPerDataInicial(Date perDataInicial) {
        this.perDataInicial = perDataInicial;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getPerDataFinal() {
        return perDataFinal;
    }

    public void setPerDataFinal(Date perDataFinal) {
        this.perDataFinal = perDataFinal;
    }

    public FpPeriodo() {
    }

    public FpPeriodo(Integer perId) {
        this.perId = perId;
    }

    public FpPeriodo(Integer perId, Date perDatainicial, Date perDatafinal, int perMes, int perAno, boolean perPagamentorealizado, int perDiasuteis, int perDiasnaouteis, long perid, int perano, int perdiasuteis, int permes) {
        this.perId = perId;
        this.perDatainicial = perDatainicial;
        this.perDatafinal = perDatafinal;
        this.perMes = perMes;
        this.perAno = perAno;
        this.perPagamentorealizado = perPagamentorealizado;
        this.perDiasuteis = perDiasuteis;
        this.perDiasnaouteis = perDiasnaouteis;
        this.perid = perid;
        this.perano = perano;
        this.perdiasuteis = perdiasuteis;
        this.permes = permes;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public Date getPerDatainicial() {
        return perDatainicial;
    }

    public void setPerDatainicial(Date perDatainicial) {
        this.perDatainicial = perDatainicial;
    }

    public Date getPerDatafinal() {
        return perDatafinal;
    }

    public void setPerDatafinal(Date perDatafinal) {
        this.perDatafinal = perDatafinal;
    }

    public int getPerMes() {
        return perMes;
    }

    public void setPerMes(int perMes) {
        this.perMes = perMes;
    }

    public int getPerAno() {
        return perAno;
    }

    public void setPerAno(int perAno) {
        this.perAno = perAno;
    }

    public boolean getPerPagamentorealizado() {
        return perPagamentorealizado;
    }

    public void setPerPagamentorealizado(boolean perPagamentorealizado) {
        this.perPagamentorealizado = perPagamentorealizado;
    }

    public int getPerDiasuteis() {
        return perDiasuteis;
    }

    public void setPerDiasuteis(int perDiasuteis) {
        this.perDiasuteis = perDiasuteis;
    }

    public int getPerDiasnaouteis() {
        return perDiasnaouteis;
    }

    public void setPerDiasnaouteis(int perDiasnaouteis) {
        this.perDiasnaouteis = perDiasnaouteis;
    }

    public long getPerid() {
        return perid;
    }

    public void setPerid(long perid) {
        this.perid = perid;
    }

    public int getPerano() {
        return perano;
    }

    public void setPerano(int perano) {
        this.perano = perano;
    }

    public Date getPerdatafinal() {
        return perdatafinal;
    }

    public void setPerdatafinal(Date perdatafinal) {
        this.perdatafinal = perdatafinal;
    }

    public Date getPerdatainicial() {
        return perdatainicial;
    }

    public void setPerdatainicial(Date perdatainicial) {
        this.perdatainicial = perdatainicial;
    }

    public int getPerdiasuteis() {
        return perdiasuteis;
    }

    public void setPerdiasuteis(int perdiasuteis) {
        this.perdiasuteis = perdiasuteis;
    }

    public int getPermes() {
        return permes;
    }

    public void setPermes(int permes) {
        this.permes = permes;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpEventosVariaveis> getFpEventosVariaveisList() {
        return fpEventosVariaveisList;
    }

    public void setFpEventosVariaveisList(List<FpEventosVariaveis> fpEventosVariaveisList) {
        this.fpEventosVariaveisList = fpEventosVariaveisList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpHorasTrabalhadas> getFpHorasTrabalhadasList() {
        return fpHorasTrabalhadasList;
    }

    public void setFpHorasTrabalhadasList(List<FpHorasTrabalhadas> fpHorasTrabalhadasList) {
        this.fpHorasTrabalhadasList = fpHorasTrabalhadasList;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpFolhasPeriodo> getFpFolhasPeriodoList() {
        return fpFolhasPeriodoList;
    }

    public void setFpFolhasPeriodoList(List<FpFolhasPeriodo> fpFolhasPeriodoList) {
        this.fpFolhasPeriodoList = fpFolhasPeriodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpPeriodo)) {
            return false;
        }
        FpPeriodo other = (FpPeriodo) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpPeriodo[ perId=" + perId + " ]";
    }

}
