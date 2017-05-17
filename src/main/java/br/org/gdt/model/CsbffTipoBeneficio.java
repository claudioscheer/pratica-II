/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.enums.TipoBeneficio;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "csbff_tipo_beneficio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffTipoBeneficio.findAll", query = "SELECT c FROM CsbffTipoBeneficio c")})
public class CsbffTipoBeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_beneficio_codigo")
    private long tipoBeneficioCodigo;
    @Basic(optional = false)
    @Column(name = "tipo_beneficio_nome")
    private String tipoBeneficioNome;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBeneficio")
    @OneToMany
    private List<CsbffTipoBeneficio> csbffBeneficiosList;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    @OneToOne(mappedBy = "tipoBeneficio")
    private RecPessoa recIdpessoa;
    private TipoBeneficio tipoBeneficio;

    public CsbffTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public CsbffTipoBeneficio(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public RecPessoa getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    public CsbffTipoBeneficio() {
    }

    public CsbffTipoBeneficio(long tipoBeneficioCodigo) {
        this.tipoBeneficioCodigo = tipoBeneficioCodigo;
    }

    public CsbffTipoBeneficio(long tipoBeneficioCodigo, String tipoBeneficioNome) {
        this.tipoBeneficioCodigo = tipoBeneficioCodigo;
        this.tipoBeneficioNome = tipoBeneficioNome;
    }

    public long getTipoBeneficioCodigo() {
        return tipoBeneficioCodigo;
    }

    public void setTipoBeneficioCodigo(long tipoBeneficioCodigo) {
        this.tipoBeneficioCodigo = tipoBeneficioCodigo;
    }

    public CsbffTipoBeneficio(long tipoBeneficioCodigo, String tipoBeneficioNome, List<CsbffBeneficios> csbffBeneficiosList) {
        this.tipoBeneficioCodigo = tipoBeneficioCodigo;
        this.tipoBeneficioNome = tipoBeneficioNome;
    }

    public String getTipoBeneficioNome() {
        return tipoBeneficioNome;
    }

    public void setTipoBeneficioNome(String tipoBeneficioNome) {
        this.tipoBeneficioNome = tipoBeneficioNome;
    }

    @XmlTransient
    @JsonIgnore
    public List<CsbffTipoBeneficio> getCsbffBeneficiosList() {
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffTipoBeneficio> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

    public TipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    

}
