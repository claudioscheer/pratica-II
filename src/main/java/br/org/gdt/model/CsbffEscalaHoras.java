/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import br.org.gdt.enums.DiasATrabalhar;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class CsbffEscalaHoras implements Serializable, SampleEntity {

    private static final long serialVersionUID = -2790083349568956163L;    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "escala_codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_csbffEscalaHoras")
    private long escalaCodigo;
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

    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne
    private RecPessoa recIdpessoa;
//    private DiasATrabalhar diasATrabalhar;
    @Basic(optional = true)
    @Column(name = "dia_dasemana")
    public String diaDaSemana;
    @OneToMany
    private List<CsbffEscalaHoras> csbffEscalaHorasList;
    private DiasATrabalhar diasATrabalhar;

    public CsbffEscalaHoras(long escalaCodigo, Date escalaDataVigente, double escalaHora1, double escalaHora2, double escalaHora3, double escalaHora4, RecPessoa recIdpessoa, String diaDaSemana, List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.escalaCodigo = escalaCodigo;
        this.escalaDataVigente = escalaDataVigente;
        this.escalaHora1 = escalaHora1;
        this.escalaHora2 = escalaHora2;
        this.escalaHora3 = escalaHora3;
        this.escalaHora4 = escalaHora4;
        this.recIdpessoa = recIdpessoa;
        this.diaDaSemana = diaDaSemana;
        this.csbffEscalaHorasList = csbffEscalaHorasList;
    }

    

    public CsbffEscalaHoras() {
    }

    public void setEscalaDataVigente(Date escalaDataVigente) {
        this.escalaDataVigente = escalaDataVigente;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

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

    @Override
    public Long getId() {
        return escalaCodigo;
    }

    public long getEscalaCodigo() {
        return escalaCodigo;
    }

    public void setEscalaCodigo(long escalaCodigo) {
        this.escalaCodigo = escalaCodigo;
    }

    public void setEscalaCodigo(CsbffEscalaHoras csbffEscalaHoras) {
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    

    public List<CsbffEscalaHoras> getCsbffEscalaHorasList() {
        return csbffEscalaHorasList;
    }

    public void setCsbffEscalaHorasList(List<CsbffEscalaHoras> csbffEscalaHorasList) {
        this.csbffEscalaHorasList = csbffEscalaHorasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.escalaCodigo ^ (this.escalaCodigo >>> 32));
        hash = 23 * hash + Objects.hashCode(this.escalaDataVigente);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.escalaHora1) ^ (Double.doubleToLongBits(this.escalaHora1) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.escalaHora2) ^ (Double.doubleToLongBits(this.escalaHora2) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.escalaHora3) ^ (Double.doubleToLongBits(this.escalaHora3) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.escalaHora4) ^ (Double.doubleToLongBits(this.escalaHora4) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.recIdpessoa);
        hash = 23 * hash + Objects.hashCode(this.diaDaSemana);
        hash = 23 * hash + Objects.hashCode(this.csbffEscalaHorasList);
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
        if (!Objects.equals(this.escalaDataVigente, other.escalaDataVigente)) {
            return false;
        }
        if (!Objects.equals(this.recIdpessoa, other.recIdpessoa)) {
            return false;
        }
        if (!Objects.equals(this.csbffEscalaHorasList, other.csbffEscalaHorasList)) {
            return false;
        }
        return true;
    }

    public DiasATrabalhar getDiasATrabalhar() {
        return diasATrabalhar;
    }

    public void setDiasATrabalhar(DiasATrabalhar diasATrabalhar) {
        this.diasATrabalhar = diasATrabalhar;
    }

}
