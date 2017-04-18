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
@Table(name = "recselecao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recselecao_1.findAll", query = "SELECT r FROM Recselecao_1 r")})
public class Recselecao_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sel_id")
    private Integer selId;
    @Basic(optional = false)
    @Column(name = "sel_aprovado")
    private boolean selAprovado;
    @Column(name = "sel_descricaoentrevista")
    private String selDescricaoentrevista;
    @JoinColumn(name = "sel_pessoa_pes_id", referencedColumnName = "pes_id")
    @ManyToOne
    private Recpessoa selPessoaPesId;
    @JoinColumn(name = "sel_vaga_vag_id", referencedColumnName = "vag_id")
    @ManyToOne
    private Recvaga selVagaVagId;

    public Recselecao_1() {
    }

    public Recselecao_1(Integer selId) {
        this.selId = selId;
    }

    public Recselecao_1(Integer selId, boolean selAprovado) {
        this.selId = selId;
        this.selAprovado = selAprovado;
    }

    public Integer getSelId() {
        return selId;
    }

    public void setSelId(Integer selId) {
        this.selId = selId;
    }

    public boolean getSelAprovado() {
        return selAprovado;
    }

    public void setSelAprovado(boolean selAprovado) {
        this.selAprovado = selAprovado;
    }

    public String getSelDescricaoentrevista() {
        return selDescricaoentrevista;
    }

    public void setSelDescricaoentrevista(String selDescricaoentrevista) {
        this.selDescricaoentrevista = selDescricaoentrevista;
    }

    public Recpessoa getSelPessoaPesId() {
        return selPessoaPesId;
    }

    public void setSelPessoaPesId(Recpessoa selPessoaPesId) {
        this.selPessoaPesId = selPessoaPesId;
    }

    public Recvaga getSelVagaVagId() {
        return selVagaVagId;
    }

    public void setSelVagaVagId(Recvaga selVagaVagId) {
        this.selVagaVagId = selVagaVagId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (selId != null ? selId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recselecao_1)) {
            return false;
        }
        Recselecao_1 other = (Recselecao_1) object;
        if ((this.selId == null && other.selId != null) || (this.selId != null && !this.selId.equals(other.selId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.Recselecao_1[ selId=" + selId + " ]";
    }
    
}
