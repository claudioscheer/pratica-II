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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "gch_treinamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GchTreinamentos.findAll", query = "SELECT g FROM GchTreinamentos g")})
public class GchTreinamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "trei_codigo")
    private Long treiCodigo;
    @Basic(optional = false)
    @Column(name = "trei_nome")
    private String treiNome;
    @Basic(optional = false)
    @Column(name = "trei_descricao")
    private String treiDescricao;
    @Basic(optional = false)
    @Column(name = "trei_datainclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date treiDatainclusao;
    
    @Basic(optional = false)
    @Column(name = "trei_data_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date treiDataInicio;
    
    @Basic(optional = false)
    @Column(name = "trei_data_fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date treiDataFim;
    
    
    @JoinColumn(name = "cur_codigo", referencedColumnName = "cur_codigo")
    @ManyToOne(optional = false)
    private GchCursos curCodigo;
    @JoinColumn(name = "mun_codigo", referencedColumnName = "mun_codigo")
    @ManyToOne(optional = false)
    private GchMunicipios munCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treiCodigo")
    private List<GchTreinamentospessoas> gchTreinamentospessoasList;
    

    public GchTreinamentos() {
    }

    public GchTreinamentos(Long treiCodigo) {
        this.treiCodigo = treiCodigo;
    }

    public GchTreinamentos(Long treiCodigo, String treiNome, String treiDescricao, Date treiDatainclusao) {
        this.treiCodigo = treiCodigo;
        this.treiNome = treiNome;
        this.treiDescricao = treiDescricao;
        this.treiDatainclusao = treiDatainclusao;
    }

    public Long getTreiCodigo() {
        return treiCodigo;
    }

    public void setTreiCodigo(Long treiCodigo) {
        this.treiCodigo = treiCodigo;
    }

    public String getTreiNome() {
        return treiNome;
    }

    public void setTreiNome(String treiNome) {
        this.treiNome = treiNome;
    }

    public String getTreiDescricao() {
        return treiDescricao;
    }

    public void setTreiDescricao(String treiDescricao) {
        this.treiDescricao = treiDescricao;
    }

    public Date getTreiDatainclusao() {
        return treiDatainclusao;
    }

    public void setTreiDatainclusao(Date treiDatainclusao) {
        this.treiDatainclusao = treiDatainclusao;
    }

    public Date getTreiDataInicio() {
        return treiDataInicio;
    }

    public void setTreiDataInicio(Date treiDataInicio) {
        this.treiDataInicio = treiDataInicio;
    }

    public Date getTreiDataFim() {
        return treiDataFim;
    }

    public void setTreiDataFim(Date treiDataFim) {
        this.treiDataFim = treiDataFim;
    }

    public GchCursos getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(GchCursos curCodigo) {
        this.curCodigo = curCodigo;
    }

    public GchMunicipios getMunCodigo() {
        return munCodigo;
    }

    public void setMunCodigo(GchMunicipios munCodigo) {
        this.munCodigo = munCodigo;
    }

    
    
    
    @XmlTransient
    @JsonIgnore
    public List<GchTreinamentospessoas> getGchTreinamentospessoasList() {
        return gchTreinamentospessoasList;
    }

    public void setGchTreinamentospessoasList(List<GchTreinamentospessoas> gchTreinamentospessoasList) {
        this.gchTreinamentospessoasList = gchTreinamentospessoasList;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treiCodigo != null ? treiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GchTreinamentos)) {
            return false;
        }
        GchTreinamentos other = (GchTreinamentos) object;
        if ((this.treiCodigo == null && other.treiCodigo != null) || (this.treiCodigo != null && !this.treiCodigo.equals(other.treiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.GchTreinamentos[ treiCodigo=" + treiCodigo + " ]";
    }


    
}
