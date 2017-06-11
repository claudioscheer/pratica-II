/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
import br.org.gdt.enums.AbrangenciaBeneficio;
import br.org.gdt.enums.TipoBeneficio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "csbff_beneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CsbffBeneficios.findAll", query = "SELECT c FROM CsbffBeneficios c")})
@SequenceGenerator(name = "seq_CsbffBeneficios", sequenceName = "seq_CsbffBeneficios", allocationSize = 1)
public class CsbffBeneficios implements java.io.Serializable, SampleEntity {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "beneficio_codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_CsbffBeneficios")
    private long beneficioCodigo;
    @Basic(optional = true)
    @Column(name = "beneficio_nome")
    private String beneficioNome;
    @Basic(optional = true)
    @Column(name = "beneficio_descricao")
    private String beneficioDescricao;
    @Basic(optional = true)
    @Column(name = "abrangencia")
    private AbrangenciaBeneficio abrangencia;
//    @Column(name = "beneficio_valor")
//    private Double beneficioValor;
    @Column(name = "befencio_data_vigente")
    @Temporal(TemporalType.DATE)
    private Date befencioDataVigente;
    private TipoBeneficio tipoBeneficio;

    public CsbffBeneficios() {
    }

    public CsbffBeneficios(long beneficioCodigo, String beneficioNome, String beneficioDescricao, AbrangenciaBeneficio abrangencia, Date befencioDataVigente, TipoBeneficio tipoBeneficio) {
        this.beneficioCodigo = beneficioCodigo;
        this.beneficioNome = beneficioNome;
        this.beneficioDescricao = beneficioDescricao;
        this.abrangencia = abrangencia;
        this.befencioDataVigente = befencioDataVigente;
        this.tipoBeneficio = tipoBeneficio;
    }

    public long getBeneficioCodigo() {
        return beneficioCodigo;
    }

    public void setBeneficioCodigo(long beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

    public String getBeneficioNome() {
        return beneficioNome;
    }

    public void setBeneficioNome(String beneficioNome) {
        this.beneficioNome = beneficioNome;
    }

    public String getBeneficioDescricao() {
        return beneficioDescricao;
    }

    public void setBeneficioDescricao(String beneficioDescricao) {
        this.beneficioDescricao = beneficioDescricao;
    }

    public AbrangenciaBeneficio getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(AbrangenciaBeneficio abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Date getBefencioDataVigente() {
        return befencioDataVigente;
    }

    public void setBefencioDataVigente(Date befencioDataVigente) {
        this.befencioDataVigente = befencioDataVigente;
    }

    public TipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.beneficioCodigo ^ (this.beneficioCodigo >>> 32));
        hash = 17 * hash + Objects.hashCode(this.beneficioNome);
        hash = 17 * hash + Objects.hashCode(this.beneficioDescricao);
        hash = 17 * hash + Objects.hashCode(this.abrangencia);
        hash = 17 * hash + Objects.hashCode(this.tipoBeneficio);
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
        final CsbffBeneficios other = (CsbffBeneficios) obj;
        if (this.beneficioCodigo != other.beneficioCodigo) {
            return false;
        }
        if (!Objects.equals(this.beneficioNome, other.beneficioNome)) {
            return false;
        }
        if (!Objects.equals(this.beneficioDescricao, other.beneficioDescricao)) {
            return false;
        }
        if (this.abrangencia != other.abrangencia) {
            return false;
        }
        if (this.tipoBeneficio != other.tipoBeneficio) {
            return false;
        }
        return true;
    }

    @Override
    public Long getId() {
        return beneficioCodigo;

    }
   

}
