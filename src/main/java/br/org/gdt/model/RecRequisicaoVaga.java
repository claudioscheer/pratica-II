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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    @Column(name = "rec_status")
    private Integer recStatus;
    @Basic(optional = true)
    @Column(name = "id_cargo")
    private String idCargo;
    @ManyToMany(mappedBy = "recVagaList")
    private List<RecHabilidade> recHabilidadeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdvaga")
    private List<RecSelecao> recSelecaoList;
    @JoinColumn(name = "cargo_codigo", referencedColumnName = "cargo_codigo")
    @ManyToOne(optional = true)
    private CsbffCargos cargoCodigo;
    @JoinColumn(name = "rec_idgrauensino", referencedColumnName = "rec_idgrauensino")
    @ManyToOne(optional = true)
    private RecGrauensino recIdgrauensino;

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

    public String getIdCargo()
    {
        return idCargo;
    }

    public void setIdCargo(String idCargo)
    {
        this.idCargo = idCargo;
    }

    public List<RecHabilidade> getRecHabilidadeList()
    {
        return recHabilidadeList;
    }

    public void setRecHabilidadeList(List<RecHabilidade> recHabilidadeList)
    {
        this.recHabilidadeList = recHabilidadeList;
    }

    public List<RecSelecao> getRecSelecaoList()
    {
        return recSelecaoList;
    }

    public void setRecSelecaoList(List<RecSelecao> recSelecaoList)
    {
        this.recSelecaoList = recSelecaoList;
    }

    public CsbffCargos getCargoCodigo()
    {
        return cargoCodigo;
    }

    public void setCargoCodigo(CsbffCargos cargoCodigo)
    {
        this.cargoCodigo = cargoCodigo;
    }

    public RecGrauensino getRecIdgrauensino()
    {
        return recIdgrauensino;
    }

    public void setRecIdgrauensino(RecGrauensino recIdgrauensino)
    {
        this.recIdgrauensino = recIdgrauensino;
    }

    

}
