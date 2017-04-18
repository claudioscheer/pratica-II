/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "horas_trabalhadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HorasTrabalhadas.findAll", query = "SELECT h FROM HorasTrabalhadas h")})
public class HorasTrabalhadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "horas100")
    private double horas100;
    @Basic(optional = false)
    @Column(name = "horas50")
    private double horas50;
    @Basic(optional = false)
    @Column(name = "horasfaltas")
    private double horasfaltas;
    @Basic(optional = false)
    @Column(name = "horasnormais")
    private double horasnormais;
    @Basic(optional = false)
    @Column(name = "horasnoturnas")
    private double horasnoturnas;
    @Basic(optional = false)
    @Column(name = "pessoa")
    private int pessoa;

    public HorasTrabalhadas() {
    }

    public HorasTrabalhadas(Long id) {
        this.id = id;
    }

    public HorasTrabalhadas(Long id, double horas100, double horas50, double horasfaltas, double horasnormais, double horasnoturnas, int pessoa) {
        this.id = id;
        this.horas100 = horas100;
        this.horas50 = horas50;
        this.horasfaltas = horasfaltas;
        this.horasnormais = horasnormais;
        this.horasnoturnas = horasnoturnas;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getHoras100() {
        return horas100;
    }

    public void setHoras100(double horas100) {
        this.horas100 = horas100;
    }

    public double getHoras50() {
        return horas50;
    }

    public void setHoras50(double horas50) {
        this.horas50 = horas50;
    }

    public double getHorasfaltas() {
        return horasfaltas;
    }

    public void setHorasfaltas(double horasfaltas) {
        this.horasfaltas = horasfaltas;
    }

    public double getHorasnormais() {
        return horasnormais;
    }

    public void setHorasnormais(double horasnormais) {
        this.horasnormais = horasnormais;
    }

    public double getHorasnoturnas() {
        return horasnoturnas;
    }

    public void setHorasnoturnas(double horasnoturnas) {
        this.horasnoturnas = horasnoturnas;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorasTrabalhadas)) {
            return false;
        }
        HorasTrabalhadas other = (HorasTrabalhadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.HorasTrabalhadas[ id=" + id + " ]";
    }
    
}
