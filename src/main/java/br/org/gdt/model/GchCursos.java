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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "gch_cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchCursos.findAll", query = "SELECT g FROM GchCursos g")})
public class GchCursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cur_codigo")
    private Long curCodigo;
    @Basic(optional = false)
    @Column(name = "cur_nome")
    private String curNome;
    @Basic(optional = false)
    @Column(name = "cur_descricao")
    private String curDescricao;
    @Basic(optional = false)
    @Column(name = "cur_datainclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date curDatainclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curCodigo")
    private List<GchTreinamentos> gchTreinamentosList;

    public GchCursos() {
    }

    public GchCursos(Long curCodigo) {
        this.curCodigo = curCodigo;
    }

    public GchCursos(Long curCodigo, String curNome, String curDescricao, Date curDatainclusao) {
        this.curCodigo = curCodigo;
        this.curNome = curNome;
        this.curDescricao = curDescricao;
        this.curDatainclusao = curDatainclusao;
    }

    public Long getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(Long curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurNome() {
        return curNome;
    }

    public void setCurNome(String curNome) {
        this.curNome = curNome;
    }

    public String getCurDescricao() {
        return curDescricao;
    }

    public void setCurDescricao(String curDescricao) {
        this.curDescricao = curDescricao;
    }

    public Date getCurDatainclusao() {
        return curDatainclusao;
    }

    public void setCurDatainclusao(Date curDatainclusao) {
        this.curDatainclusao = curDatainclusao;
    }

    @XmlTransient
    @JsonIgnore
    public List<GchTreinamentos> getGchTreinamentosList() {
        return gchTreinamentosList;
    }

    public void setGchTreinamentosList(List<GchTreinamentos> gchTreinamentosList) {
        this.gchTreinamentosList = gchTreinamentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curCodigo != null ? curCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchCursos)) {
            return false;
        }
        GchCursos other = (GchCursos) object;
        if ((this.curCodigo == null && other.curCodigo != null) || (this.curCodigo != null && !this.curCodigo.equals(other.curCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchCursos[ curCodigo=" + curCodigo + " ]";
    }
    
}
