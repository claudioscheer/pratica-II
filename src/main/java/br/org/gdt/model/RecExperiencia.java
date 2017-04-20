/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "rec_experiencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecExperiencia_1.findAll", query = "SELECT r FROM RecExperiencia_1 r")})
public class RecExperiencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idexperiencia")
    private Integer recIdexperiencia;
    @Column(name = "rec_empresa")
    private String recEmpresa;
    @Column(name = "rec_area")
    private String recArea;
    @Column(name = "rec_cargo")
    private String recCargo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rec_salario")
    private Float recSalario;
    @Column(name = "rec_dtinicial")
    @Temporal(TemporalType.DATE)
    private Date recDtinicial;
    @Column(name = "rec_dtfinal")
    @Temporal(TemporalType.DATE)
    private Date recDtfinal;
    @Column(name = "rec_atividade")
    private String recAtividade;
    @Column(name = "rec_motivosaida")
    private String recMotivosaida;
    @JoinTable(name = "rec_pessoa_experiencia", joinColumns = {
        @JoinColumn(name = "rec_idexperiencia", referencedColumnName = "rec_idexperiencia")}, inverseJoinColumns = {
        @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")})
    @ManyToMany
    private List<RecPessoa> recPessoaList;

    public RecExperiencia() {
    }

    public RecExperiencia(Integer recIdexperiencia) {
        this.recIdexperiencia = recIdexperiencia;
    }

    public Integer getRecIdexperiencia() {
        return recIdexperiencia;
    }

    public void setRecIdexperiencia(Integer recIdexperiencia) {
        this.recIdexperiencia = recIdexperiencia;
    }

    public String getRecEmpresa() {
        return recEmpresa;
    }

    public void setRecEmpresa(String recEmpresa) {
        this.recEmpresa = recEmpresa;
    }

    public String getRecArea() {
        return recArea;
    }

    public void setRecArea(String recArea) {
        this.recArea = recArea;
    }

    public String getRecCargo() {
        return recCargo;
    }

    public void setRecCargo(String recCargo) {
        this.recCargo = recCargo;
    }

    public Float getRecSalario() {
        return recSalario;
    }

    public void setRecSalario(Float recSalario) {
        this.recSalario = recSalario;
    }

    public Date getRecDtinicial() {
        return recDtinicial;
    }

    public void setRecDtinicial(Date recDtinicial) {
        this.recDtinicial = recDtinicial;
    }

    public Date getRecDtfinal() {
        return recDtfinal;
    }

    public void setRecDtfinal(Date recDtfinal) {
        this.recDtfinal = recDtfinal;
    }

    public String getRecAtividade() {
        return recAtividade;
    }

    public void setRecAtividade(String recAtividade) {
        this.recAtividade = recAtividade;
    }

    public String getRecMotivosaida() {
        return recMotivosaida;
    }

    public void setRecMotivosaida(String recMotivosaida) {
        this.recMotivosaida = recMotivosaida;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecPessoa> getRecPessoaList() {
        return recPessoaList;
    }

    public void setRecPessoaList(List<RecPessoa> recPessoaList) {
        this.recPessoaList = recPessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recIdexperiencia != null ? recIdexperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecExperiencia)) {
            return false;
        }
        RecExperiencia other = (RecExperiencia) object;
        if ((this.recIdexperiencia == null && other.recIdexperiencia != null) || (this.recIdexperiencia != null && !this.recIdexperiencia.equals(other.recIdexperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.RecExperiencia_1[ recIdexperiencia=" + recIdexperiencia + " ]";
    }
    
}
