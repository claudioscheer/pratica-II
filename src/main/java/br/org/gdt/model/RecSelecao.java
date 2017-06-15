/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@SequenceGenerator(name = "seq_RecSelecao", sequenceName = "seq_RecSelecao", allocationSize = 1)
public class RecSelecao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idselecao")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_RecSelecao")
    private long recIdselecao;
    @Column(name = "rec_descricaoentrevista")
    private String recDescricaoentrevista;
    @Basic(optional = true)
    @Column(name = "rec_aprovado")
    private Boolean recAprovado;
    @Column(name = "rec_dataentrevista")
    @Temporal(TemporalType.DATE)
    private Date recDataEntrevista;
    //@JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private RecPessoa recIdpessoa;
    //@JoinColumn(name = "rec_idvaga", referencedColumnName = "rec_idvaga")
    @ManyToOne(optional = true)
    private RecVaga recIdvaga;

    public RecSelecao(long recIdselecao, String recDescricaoentrevista, Boolean recAprovado, Date recDataEntrevista, RecPessoa recIdpessoa, RecVaga recIdvaga) {
        this.recIdselecao = recIdselecao;
        this.recDescricaoentrevista = recDescricaoentrevista;
        this.recAprovado = recAprovado;
        this.recDataEntrevista = recDataEntrevista;
        this.recIdpessoa = recIdpessoa;
        this.recIdvaga = recIdvaga;
    }

    

    public RecSelecao() {
    }

    public RecSelecao(int recIdselecao) {
        this.recIdselecao = recIdselecao;
    }

    public long getRecIdselecao() {
        return recIdselecao;
    }

    public void setRecIdselecao(int recIdselecao) {
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
    
//    @Override
//    public String toString() {
//        return "br.org.gdt.modelNew.RecSelecao[ recIdselecao=" + recIdselecao + " ]";
//    }

    public void setRecIdselecao(long recIdselecao) {
        this.recIdselecao = recIdselecao;
    }

    public Date getRecDataEntrevista() {
        return recDataEntrevista;
    }

    public void setRecDataEntrevista(Date recDataEntrevista) {
        this.recDataEntrevista = recDataEntrevista;
    }
    
}
