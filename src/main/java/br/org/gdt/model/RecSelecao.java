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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "rec_selecao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecSelecao.findAll", query = "SELECT r FROM RecSelecao r")})
public class RecSelecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idselecao")
    private String recIdselecao;
    @Column(name = "rec_descricaoentrevista")
    private String recDescricaoentrevista;
    @Column(name = "rec_aprovado")
    private Boolean recAprovado;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;
    @JoinColumn(name = "rec_idvaga", referencedColumnName = "rec_idvaga")
    @ManyToOne(optional = false)
    private RecVaga recIdvaga;

    public RecSelecao() {
    }

    public RecSelecao(String recIdselecao) {
        this.recIdselecao = recIdselecao;
    }

    public String getRecIdselecao() {
        return recIdselecao;
    }

    public void setRecIdselecao(String recIdselecao) {
        this.recIdselecao = recIdselecao;
    }

    public String getRecDescricaoentrevista() {
        return recDescricaoentrevista;
    }

    public void setRecDescricaoentrevista(String recDescricaoentrevista) {
        this.recDescricaoentrevista = recDescricaoentrevista;
    }

    public Boolean getRecAprovado() {
        return recAprovado;
    }

    public void setRecAprovado(Boolean recAprovado) {
        this.recAprovado = recAprovado;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public RecVaga getRecIdvaga() {
        return recIdvaga;
    }

    public void setRecIdvaga(RecVaga recIdvaga) {
        this.recIdvaga = recIdvaga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recIdselecao != null ? recIdselecao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecSelecao)) {
            return false;
        }
        RecSelecao other = (RecSelecao) object;
        if ((this.recIdselecao == null && other.recIdselecao != null) || (this.recIdselecao != null && !this.recIdselecao.equals(other.recIdselecao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.RecSelecao[ recIdselecao=" + recIdselecao + " ]";
    }
    
}
