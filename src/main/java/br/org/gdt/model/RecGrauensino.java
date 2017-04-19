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
@Table(name = "recgrauensino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recgrauensino_1.findAll", query = "SELECT r FROM Recgrauensino_1 r")})
public class RecGrauensino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "gre_id")
    private Integer greId;
    @Column(name = "gre_anoconclusao")
    @Temporal(TemporalType.DATE)
    private Date greAnoconclusao;
    @Column(name = "gre_anoinicio")
    @Temporal(TemporalType.DATE)
    private Date greAnoinicio;
    @Column(name = "gre_grauensinosituacao")
    private Integer greGrauensinosituacao;
    @Column(name = "gre_grauensinotipo")
    private Integer greGrauensinotipo;
    @Column(name = "gre_instituicao")
    private String greInstituicao;
    @OneToMany(mappedBy = "vagGrauensinoGreId")
    private List<RecVaga> recvagaList;

    public RecGrauensino() {
    }

    public RecGrauensino(Integer greId) {
        this.greId = greId;
    }

    public Integer getGreId() {
        return greId;
    }

    public void setGreId(Integer greId) {
        this.greId = greId;
    }

    public Date getGreAnoconclusao() {
        return greAnoconclusao;
    }

    public void setGreAnoconclusao(Date greAnoconclusao) {
        this.greAnoconclusao = greAnoconclusao;
    }

    public Date getGreAnoinicio() {
        return greAnoinicio;
    }

    public void setGreAnoinicio(Date greAnoinicio) {
        this.greAnoinicio = greAnoinicio;
    }

    public Integer getGreGrauensinosituacao() {
        return greGrauensinosituacao;
    }

    public void setGreGrauensinosituacao(Integer greGrauensinosituacao) {
        this.greGrauensinosituacao = greGrauensinosituacao;
    }

    public Integer getGreGrauensinotipo() {
        return greGrauensinotipo;
    }

    public void setGreGrauensinotipo(Integer greGrauensinotipo) {
        this.greGrauensinotipo = greGrauensinotipo;
    }

    public String getGreInstituicao() {
        return greInstituicao;
    }

    public void setGreInstituicao(String greInstituicao) {
        this.greInstituicao = greInstituicao;
    }

    @XmlTransient
    @JsonIgnore
    public List<RecVaga> getRecvagaList() {
        return recvagaList;
    }

    public void setRecvagaList(List<RecVaga> recvagaList) {
        this.recvagaList = recvagaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (greId != null ? greId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecGrauensino)) {
            return false;
        }
        RecGrauensino other = (RecGrauensino) object;
        if ((this.greId == null && other.greId != null) || (this.greId != null && !this.greId.equals(other.greId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.Recgrauensino_1[ greId=" + greId + " ]";
    }
    
}
