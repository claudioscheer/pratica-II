/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.enums.DiasATrabalhar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Diego
 */
@Entity
@SequenceGenerator(name = "seq_csbffEscalaHoras", sequenceName = "seq_csbffEscalaHoras", allocationSize = 1)
@Table(name = "csbffEscalaHoras")
public class CsbffEscalaHoras implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "escala_codigo")
    private int escalaCodigo;
    @Column(name = "escala_data_vigente")
    @Temporal(TemporalType.DATE)
    private Date escalaDataVigente;
    @Column(name = "escala_hora1")
//    @Temporal(TemporalType.TIME)
    private double escalaHora1;
    @Column(name = "escala_hora2")
//    @Temporal(TemporalType.TIME)
    private double escalaHora2;
    @Column(name = "escala_hora3")
//    @Temporal(TemporalType.DATE)
    private double escalaHora3;
    @Column(name = "escala_hora4")
//    @Temporal(TemporalType.TIME)
    private double escalaHora4;
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
    private RecPessoa recIdpessoa;
//    @OneToMany
//    private List<CsbffEscalaHoras> csbffEscalaHorasList;
    private DiasATrabalhar diasATrabalhar;
    private String diaDaSemana;

    public CsbffEscalaHoras(int escalaCodigo, Date escalaDataVigente, double escalaHora1, double escalaHora2, double escalaHora3, double escalaHora4, Boolean escalaSegunda, Boolean escalaTerca, Boolean escalaQuarta, Boolean escalaQuinta, Boolean escalaSexta, Boolean escalaSabado, Boolean escalaDomingo, RecPessoa recIdpessoa, DiasATrabalhar diasATrabalhar, String diaDaSemana) {
        this.escalaCodigo = escalaCodigo;
        this.escalaDataVigente = escalaDataVigente;
        this.escalaHora1 = escalaHora1;
        this.escalaHora2 = escalaHora2;
        this.escalaHora3 = escalaHora3;
        this.escalaHora4 = escalaHora4;
        this.escalaSegunda = escalaSegunda;
        this.escalaTerca = escalaTerca;
        this.escalaQuarta = escalaQuarta;
        this.escalaQuinta = escalaQuinta;
        this.escalaSexta = escalaSexta;
        this.escalaSabado = escalaSabado;
        this.escalaDomingo = escalaDomingo;
        this.recIdpessoa = recIdpessoa;
        this.diasATrabalhar = diasATrabalhar;
        this.diaDaSemana = diaDaSemana;
    }

  
    public CsbffEscalaHoras() {
    }
    

    public void addEscalas(CsbffEscalaHoras csbffEscalaHoras) {
//        if (csbffEscalaHoras != null) {
//            csbffEscalaHoras.setCsbffEscalaHorasList((List<CsbffEscalaHoras>) this);
//            this.getCsbffEscalaHorasList().add(0, csbffEscalaHoras);
//        }
        if (csbffEscalaHoras != null) {
            csbffEscalaHoras.setEscalaCodigo(escalaCodigo);
        }
    }

   //    public void addNovaEscala(CsbffEscalaHoras csbffEscalaHoras) {
//        if (csbffEscalaHoras != null) {
//            csbffEscalaHoras.setEscalaCodigo(1);
//
//        }
//    }
    public void setEscalaDataVigente(Date escalaDataVigente) {
        this.escalaDataVigente = escalaDataVigente;
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

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (escalaCodigo != null ? escalaCodigo.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof CsbffEscalaHoras)) {
//            return false;
//        }
//        CsbffEscalaHoras other = (CsbffEscalaHoras) object;
//        if ((this.escalaCodigo == null && other.escalaCodigo != null) || (this.escalaCodigo != null && !this.escalaCodigo.equals(other.escalaCodigo))) {
//            return false;
//        }
//        return true;
//    }
//    @Override
//    public String toString() {
//        return "br.org.gdt.modelNew.CsbffEscalaHoras[ escalaCodigo=" + escalaCodigo + " ]";
//    }

    public double getEscalaHora1() {
        return escalaHora1;
    }

    public void setEscalaHora1(double escalaHora1) {
        this.escalaHora1 = escalaHora1;
    }

    public double getEscalaHora2() {
        return escalaHora2;
    }

    public void setEscalaHora2(double escalaHora2) {
        this.escalaHora2 = escalaHora2;
    }

    public double getEscalaHora3() {
        return escalaHora3;
    }

    public void setEscalaHora3(double escalaHora3) {
        this.escalaHora3 = escalaHora3;
    }

    public double getEscalaHora4() {
        return escalaHora4;
    }

    public void setEscalaHora4(double escalaHora4) {
        this.escalaHora4 = escalaHora4;
    }

//    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
//        this.csbffEscalaHorasList = csbffEscalaHorasList;
//    }
//
//    public List<CsbffEscalaHoras> getCsbffEscalaHorasList() {
//        if (this.csbffEscalaHorasList == null) {
//            this.csbffEscalaHorasList = new ArrayList<>();
//        }
//        return csbffEscalaHorasList;
//    }

    public int getEscalaCodigo() {
        return escalaCodigo;
    }

    public void setEscalaCodigo(int escalaCodigo) {
        this.escalaCodigo = escalaCodigo;
    }

    public DiasATrabalhar getDiasATrabalhar() {
        return diasATrabalhar;
    }

    public void setDiasATrabalhar(DiasATrabalhar diasATrabalhar) {
        this.diasATrabalhar = diasATrabalhar;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.escalaCodigo;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.escalaHora1) ^ (Double.doubleToLongBits(this.escalaHora1) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.escalaHora2) ^ (Double.doubleToLongBits(this.escalaHora2) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.escalaHora3) ^ (Double.doubleToLongBits(this.escalaHora3) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.escalaHora4) ^ (Double.doubleToLongBits(this.escalaHora4) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.diasATrabalhar);
        hash = 97 * hash + Objects.hashCode(this.diaDaSemana);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CsbffEscalaHoras other = (CsbffEscalaHoras) obj;
        if (this.escalaCodigo != other.escalaCodigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.escalaHora1) != Double.doubleToLongBits(other.escalaHora1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.escalaHora2) != Double.doubleToLongBits(other.escalaHora2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.escalaHora3) != Double.doubleToLongBits(other.escalaHora3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.escalaHora4) != Double.doubleToLongBits(other.escalaHora4)) {
            return false;
        }
        if (!Objects.equals(this.diaDaSemana, other.diaDaSemana)) {
            return false;
        }
        if (this.diasATrabalhar != other.diasATrabalhar) {
            return false;
        }
        return true;
    }

}
