/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    private long  pessoaBeneficioCodigo;
    @JoinColumn(name = "beneficio_codigo", referencedColumnName = "beneficio_codigo")
    @ManyToOne(optional = false)
    private CsbffBeneficios beneficioCodigo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa recIdpessoa;
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "recIdpessoa")
    private List<CsbffPessoaBeneficio> csbffPessoaBeneficioList;
    
    public CsbffPessoaBeneficio() {
    }

    public CsbffPessoaBeneficio(long  pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public long  getPessoaBeneficioCodigo() {
        return pessoaBeneficioCodigo;
    }

    public void setPessoaBeneficioCodigo(long  pessoaBeneficioCodigo) {
        this.pessoaBeneficioCodigo = pessoaBeneficioCodigo;
    }

    public CsbffBeneficios getBeneficioCodigo() {
        return beneficioCodigo;
    }

    public CsbffPessoaBeneficio(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
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



    public List<CsbffPessoaBeneficio> getCsbffPessoaBeneficioList() {
        return csbffPessoaBeneficioList;
    }

    public void setCsbffPessoaBeneficioList(List<CsbffPessoaBeneficio> csbffPessoaBeneficioList) {
        this.csbffPessoaBeneficioList = csbffPessoaBeneficioList;
    }

    public Object csbffPessoaBeneficioList() {
        return csbffPessoaBeneficioList;
    }
    public void addBePessoa(CsbffPessoaBeneficio csbffPessoaBeneficio) {
        if (csbffPessoaBeneficio != null) {
            csbffPessoaBeneficio.setCsbffPessoaBeneficioList((List<CsbffPessoaBeneficio>) this);
            this.getCsbffPessoaBeneficioList().add(csbffPessoaBeneficio);
        
        }
    }    
         
    
}
