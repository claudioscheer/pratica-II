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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *

 */
@Entity
@Table(name = "rec_requisicao_vaga")
@XmlRootElement
@SequenceGenerator(name = "seq_RecRequisicaoVaga", sequenceName = "seq_RecRequisicaoVaga", allocationSize = 1)
public class RecRequisicaoVaga implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rec_idRequisicaoVaga")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_RecRequisicaoVaga")
    private long recIdRecquisicaoVaga;
    @Column(name = "rec_descricao")
    private String recDescricao;
    @Column(name = "rec_sexo")
    private Integer recSexo;
    @Column(name = "rec_datavencimento")
    @Temporal(TemporalType.DATE)
    private Date recDatavencimento;
    @Column(name = "rec_status")
    private Integer recStatus;                
    private int recIdgrauensino;

    public RecRequisicaoVaga()
    {
    }

    public long getRecIdRecquisicaoVaga()
    {
        return recIdRecquisicaoVaga;
    }

    public void setRecIdRecquisicaoVaga(long recIdRecquisicaoVaga)
    {
        this.recIdRecquisicaoVaga = recIdRecquisicaoVaga;
    }

    public String getRecDescricao()
    {
        return recDescricao;
    }

    public void setRecDescricao(String recDescricao)
    {
        this.recDescricao = recDescricao;
    }

    public Integer getRecSexo()
    {
        return recSexo;
    }

    public void setRecSexo(Integer recSexo)
    {
        this.recSexo = recSexo;
    }

    public Date getRecDatavencimento()
    {
        return recDatavencimento;
    }

    public void setRecDatavencimento(Date recDatavencimento)
    {
        this.recDatavencimento = recDatavencimento;
    }

    public Integer getRecStatus()
    {
        return recStatus;
    }

    public void setRecStatus(Integer recStatus)
    {
        this.recStatus = recStatus;
    }  

    public int getRecIdgrauensino()
    {
        return recIdgrauensino;
    }

    public void setRecIdgrauensino(int recIdgrauensino)
    {
        this.recIdgrauensino = recIdgrauensino;
    }

    

}
