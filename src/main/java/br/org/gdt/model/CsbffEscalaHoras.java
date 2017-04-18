/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "csbff_escala_horas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffEscalaHoras.findAll", query = "SELECT c FROM CsbffEscalaHoras c")})
public class CsbffEscalaHoras implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "escala_codigo")
    private BigDecimal escalaCodigo;
    @Column(name = "escala_data_vigente")
    @Temporal(TemporalType.DATE)
    private Date escalaDataVigente;
    @Column(name = "escala_hora1")
    @Temporal(TemporalType.TIME)
    private Date escalaHora1;
    @Column(name = "escala_hora2")
    @Temporal(TemporalType.TIME)
    private Date escalaHora2;
    @Column(name = "escala_hora3")
    @Temporal(TemporalType.DATE)
    private Date escalaHora3;
    @Column(name = "escala_hora4")
    @Temporal(TemporalType.TIME)
    private Date escalaHora4;
    @Column(name = "escala_segunda")
    private Boolean escalaSegunda;
    @Column(name = "escala_terca")
    private Boolean escalaTerca;
    @Column(name = "escala_quarta")
    private Boolean escalaQuarta;
    @Column(name = "escala_quinta")
    private Boolean escalaQuinta;
    @Column(name = "escala_sexta")
    private Boolean escalaSexta;
    @Column(name = "escala_sabado")
    private Boolean escalaSabado;
    @Column(name = "escala_domingo")
    private Boolean escalaDomingo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @OneToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    public CsbffEscalaHoras() {
    }

    public CsbffEscalaHoras(BigDecimal escalaCodigo) {
        this.escalaCodigo = escalaCodigo;
    }

    public BigDecimal getEscalaCodigo() {
        return escalaCodigo;
    }

    public void setEscalaCodigo(BigDecimal escalaCodigo) {
        this.escalaCodigo = escalaCodigo;
    }

    public Date getEscalaDataVigente() {
        return escalaDataVigente;
    }

    public void setEscalaDataVigente(Date escalaDataVigente) {
        this.escalaDataVigente = escalaDataVigente;
    }

    public Date getEscalaHora1() {
        return escalaHora1;
    }

    public void setEscalaHora1(Date escalaHora1) {
        this.escalaHora1 = escalaHora1;
    }

    public Date getEscalaHora2() {
        return escalaHora2;
    }

    public void setEscalaHora2(Date escalaHora2) {
        this.escalaHora2 = escalaHora2;
    }

    public Date getEscalaHora3() {
        return escalaHora3;
    }

    public void setEscalaHora3(Date escalaHora3) {
        this.escalaHora3 = escalaHora3;
    }

    public Date getEscalaHora4() {
        return escalaHora4;
    }

    public void setEscalaHora4(Date escalaHora4) {
        this.escalaHora4 = escalaHora4;
    }

    public Boolean getEscalaSegunda() {
        return escalaSegunda;
    }

    public void setEscalaSegunda(Boolean escalaSegunda) {
        this.escalaSegunda = escalaSegunda;
    }

    public Boolean getEscalaTerca() {
        return escalaTerca;
    }

    public void setEscalaTerca(Boolean escalaTerca) {
        this.escalaTerca = escalaTerca;
    }

    public Boolean getEscalaQuarta() {
        return escalaQuarta;
    }

    public void setEscalaQuarta(Boolean escalaQuarta) {
        this.escalaQuarta = escalaQuarta;
    }

    public Boolean getEscalaQuinta() {
        return escalaQuinta;
    }

    public void setEscalaQuinta(Boolean escalaQuinta) {
        this.escalaQuinta = escalaQuinta;
    }

    public Boolean getEscalaSexta() {
        return escalaSexta;
    }

    public void setEscalaSexta(Boolean escalaSexta) {
        this.escalaSexta = escalaSexta;
    }

    public Boolean getEscalaSabado() {
        return escalaSabado;
    }

    public void setEscalaSabado(Boolean escalaSabado) {
        this.escalaSabado = escalaSabado;
    }

    public Boolean getEscalaDomingo() {
        return escalaDomingo;
    }

    public void setEscalaDomingo(Boolean escalaDomingo) {
        this.escalaDomingo = escalaDomingo;
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
        hash += (escalaCodigo != null ? escalaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsbffEscalaHoras)) {
            return false;
        }
        CsbffEscalaHoras other = (CsbffEscalaHoras) object;
        if ((this.escalaCodigo == null && other.escalaCodigo != null) || (this.escalaCodigo != null && !this.escalaCodigo.equals(other.escalaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffEscalaHoras[ escalaCodigo=" + escalaCodigo + " ]";
    }
    
}
