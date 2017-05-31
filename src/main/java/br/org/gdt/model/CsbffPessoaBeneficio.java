/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "csbff_pessoa_beneficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffPessoaBeneficio.findAll", query = "SELECT c FROM CsbffPessoaBeneficio c")})
public class CsbffPessoaBeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_beneficio_codigo")
    private long pessoaBeneficioCodigo;

    @JoinColumn(name = "beneficio_codigo", referencedColumnName = "beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffBeneficios beneficioCodigo;

    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
//    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
//    @Basic(optional = true)
//    @Column(name = "pessoa_beneficioNome")
//    private String pessoaBeneficioNome;
    public CsbffPessoaBeneficio() {
    }

//    public CsbffPessoaBeneficio(long pessoaBeneficioCodigo, RecPessoa recIdpessoa, List<CsbffPessoaBeneficio> csbffPessoaBeneficioList, String pessoaBeneficioNome) {
//        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
//        this.recIdpessoa = recIdpessoa;
//        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
//        this.pessoaBeneficioNome = pessoaBeneficioNome;
//    }
    public CsbffPessoaBeneficio(long pessoaBeneficioCodigo, CsbffBeneficios beneficioCodigo, RecPessoa recIdpessoa) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
        this.beneficioCodigo = beneficioCodigo;
        this.recIdpessoa = recIdpessoa;
    }

//
//    public void addBePessoa(CsbffPessoaBeneficio csbffPessoaBeneficio) {
//        if (csbffPessoaBeneficio != null) {
//            csbffPessoaBeneficio.setCsbffPessoaBeneficioList((List<CsbffPessoaBeneficio>) this);
//            this.getCsbffPessoaBeneficioList().add(csbffPessoaBeneficio);
//
//        }
//    }
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

//    public List<CsbffPessoaBeneficio> getCsbffPessoaBeneficioList() {
//        return csbffPessoaBeneficioList;
//    }
//
//    public void setCsbffPessoaBeneficioList(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
//        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
//    }
//    public CsbffBeneficios getBeneficioNome() {
//        return beneficioNome;
//    }
//
//    public void setBeneficioNome(CsbffBeneficios beneficioNome) {
//        this.beneficioNome = beneficioNome;
//    }
//
//    public CsbffBeneficios getPessoaBeneficioNome() {
//        return pessoaBeneficioNome;
//    }
//    public void setPessoaBeneficioNome(CsbffBeneficios pessoaBeneficioNome) {
//        this.pessoaBeneficioNome = pessoaBeneficioNome;
//    }
//    public String getPessoaBeneficioNome() {
//        return pessoaBeneficioNome;
//    }
//
//    public void setPessoaBeneficioNome(String pessoaBeneficioNome) {
//        this.pessoaBeneficioNome = pessoaBeneficioNome;
//    }

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


}
