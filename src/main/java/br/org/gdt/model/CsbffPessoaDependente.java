/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.enums.PossuiDependentes;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@SequenceGenerator(name = "seq_pessoa_dependente", sequenceName = "seq_pessoa_dependente", allocationSize = 1)
@Table(name = "csbff_pessoa_dependente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffPessoaDependente.findAll", query = "SELECT c FROM CsbffPessoaDependente c")})
public class CsbffPessoaDependente implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_dependente")
    @Basic(optional = false)
    @Column(name = "colab_dep_codigo")
    private long colabDepCodigo;
    @JoinColumn(name = "dependente_cod", referencedColumnName = "dependente_cod")
    @OneToOne(fetch = FetchType.EAGER)
    private CsbffDependentes dependenteCod;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @OneToOne(optional = false)
    private RecPessoa recIdpessoa;
    private PossuiDependentes possuiDependentes;

    public CsbffPessoaDependente(PossuiDependentes possuiDependentes) {
        this.possuiDependentes = possuiDependentes;
    }

    public CsbffPessoaDependente() {
    }

    public CsbffPessoaDependente(long colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public long getColabDepCodigo() {
        return colabDepCodigo;
    }

    public void setColabDepCodigo(long colabDepCodigo) {
        this.colabDepCodigo = colabDepCodigo;
    }

    public CsbffDependentes getDependenteCod() {
        return dependenteCod;
    }

    public void setDependenteCod(CsbffDependentes dependenteCod) {
        this.dependenteCod = dependenteCod;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public PossuiDependentes getPossuiDependentes() {
        return possuiDependentes;
    }

    public void setPossuiDependentes(PossuiDependentes possuiDependentes) {
        this.possuiDependentes = possuiDependentes;
    }

    }

  

