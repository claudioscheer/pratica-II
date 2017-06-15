/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import br.org.gdt.enums.PossuiDependentes;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
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

public class CsbffPessoaDependente implements Serializable, SampleEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa_dependente")
    @Basic(optional = false)
    @Column(name = "colab_dep_codigo")
    private long colabDepCodigo;

    @JoinColumn(name = "dependente_cod", referencedColumnName = "dependente_cod")
    @ManyToOne(optional = false)
    private CsbffDependentes dependenteCod;

    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne
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

    @Override
    public Long getId() {
        return colabDepCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (this.colabDepCodigo ^ (this.colabDepCodigo >>> 32));
        hash = 29 * hash + Objects.hashCode(this.dependenteCod);
        hash = 29 * hash + Objects.hashCode(this.recIdpessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CsbffPessoaDependente other = (CsbffPessoaDependente) obj;
        if (this.colabDepCodigo != other.colabDepCodigo) {
            return false;
        }
        if (!Objects.equals(this.dependenteCod, other.dependenteCod)) {
            return false;
        }
        if (!Objects.equals(this.recIdpessoa, other.recIdpessoa)) {
            return false;
        }
        return true;
    }

}
