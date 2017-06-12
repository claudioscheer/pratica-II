/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego
 */
@Entity
@SequenceGenerator(name = "seq_csbffpessoabeneficio", sequenceName = "seq_csbffpessoabeneficio", allocationSize = 1)
@Table(name = "csbffpessoabeneficio")
public class CsbffPessoaBeneficio implements Serializable, SampleEntity {

    private static final long serialVersionUID = -2790083349568956163L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_beneficio_codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_csbffpessoabeneficio")
    private long pessoaBeneficioCodigo;

    @JoinColumn(name = "beneficio_codigo", referencedColumnName = "beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffBeneficios beneficioCodigo;

    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne
    private RecPessoa recIdpessoa;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "recIdpessoa")
    private List<CsbffBeneficios> csbffBeneficiosList;

    public CsbffPessoaBeneficio() {
    }

    public CsbffPessoaBeneficio(long pessoaBeneficioCodigo, CsbffBeneficios beneficioCodigo, RecPessoa recIdpessoa) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
        this.beneficioCodigo = beneficioCodigo;
        this.recIdpessoa = recIdpessoa;
    }

    public long getPessoaBeneficioCodigo() {
        return pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(long pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
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
        int hash = 5;
        hash = 53 * hash + (int) (this.pessoaBeneficioCodigo ^ (this.pessoaBeneficioCodigo >>> 32));
        hash = 53 * hash + Objects.hashCode(this.beneficioCodigo);
        hash = 53 * hash + Objects.hashCode(this.recIdpessoa);
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

    public List<CsbffBeneficios> getCsbffBeneficiosList() {
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

    @Override
    public Long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
