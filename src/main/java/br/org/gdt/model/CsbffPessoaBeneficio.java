/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "csbff_pessoa_beneficio")
@SequenceGenerator(name = "seq_csbff_pessoa_beneficio", sequenceName = "seq_csbff_pessoa_beneficio", allocationSize = 1)

public class CsbffPessoaBeneficio implements Serializable, SampleEntity {

    private static final long serialVersionUID = -2790083349568956163L;
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_beneficio_codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_csbff_pessoa_beneficio")
    private long pessoaBeneficioCodigo;

    @JoinColumn(name = "beneficio_codigo", referencedColumnName = "beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffBeneficios beneficioCodigo;

    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne
    private RecPessoa recIdpessoa;

    public CsbffPessoaBeneficio() {
    }

    public CsbffPessoaBeneficio(long pessoaBeneficioCodigo, CsbffBeneficios beneficioCodigo, RecPessoa recIdpessoa) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
        this.beneficioCodigo = beneficioCodigo;
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public Long getId() {
        return pessoaBeneficioCodigo;
    }

    public long getPessoaBeneficioCodigo() {
        return pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(long pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(CsbffPessoaBeneficio csbffPessoaBeneficio) {
    }

    public CsbffBeneficios getBeneficioCodigo() {
        return beneficioCodigo;
    }

    public void setBeneficioCodigo(CsbffBeneficios beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.pessoaBeneficioCodigo ^ (this.pessoaBeneficioCodigo >>> 32));
        hash = 29 * hash + Objects.hashCode(this.beneficioCodigo);
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
        final CsbffPessoaBeneficio other = (CsbffPessoaBeneficio) obj;
        if (this.pessoaBeneficioCodigo != other.pessoaBeneficioCodigo) {
            return false;
        }
        if (!Objects.equals(this.beneficioCodigo, other.beneficioCodigo)) {
            return false;
        }
        if (!Objects.equals(this.recIdpessoa, other.recIdpessoa)) {
            return false;
        }
        return true;
    }

}
