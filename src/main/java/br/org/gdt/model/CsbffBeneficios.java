/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.model;

import br.org.gdt.converts.SampleEntity;
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
    private String abrangencia;
    @Column(name = "beneficio_valor")
    private Double beneficioValor;
    @Column(name = "befencio_data_vigente")
    @Temporal(TemporalType.DATE)
    private Date befencioDataVigente;
    private TipoBeneficio tipoBeneficio;
    @OneToMany
    private List<CsbffBeneficios> csbffBeneficiosList;

    public CsbffBeneficios(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

    public CsbffBeneficios(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    public CsbffBeneficios() {
    }

    public CsbffBeneficios(long beneficioCodigo) {
        this.beneficioCodigo = beneficioCodigo;
    }

//    public CsbffBeneficios(String string) {
//    }
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

    public String getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(String abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Double getBeneficioValor() {
        return beneficioValor;
    }

    public void setBeneficioValor(Double beneficioValor) {
        this.beneficioValor = beneficioValor;
    }

    public Date getBefencioDataVigente() {
        return befencioDataVigente;
    }

    public void setBefencioDataVigente(Date befencioDataVigente) {
        this.befencioDataVigente = befencioDataVigente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.beneficioCodigo);
        hash = 89 * hash + Objects.hashCode(this.beneficioNome);
        hash = 89 * hash + Objects.hashCode(this.beneficioDescricao);
        hash = 89 * hash + Objects.hashCode(this.abrangencia);
        hash = 89 * hash + Objects.hashCode(this.beneficioValor);
        hash = 89 * hash + Objects.hashCode(this.befencioDataVigente);
        hash = 89 * hash + Objects.hashCode(this.tipoBeneficio);
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
        if (!Objects.equals(this.beneficioNome, other.beneficioNome)) {
            return false;
        }
        if (!Objects.equals(this.beneficioDescricao, other.beneficioDescricao)) {
            return false;
        }
        if (!Objects.equals(this.abrangencia, other.abrangencia)) {
            return false;
        }
        if (!Objects.equals(this.beneficioCodigo, other.beneficioCodigo)) {
            return false;
        }
        if (!Objects.equals(this.beneficioValor, other.beneficioValor)) {
            return false;
        }
        if (!Objects.equals(this.befencioDataVigente, other.befencioDataVigente)) {
            return false;
        }
        if (!Objects.equals(this.tipoBeneficio, other.tipoBeneficio)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.modelNew.CsbffBeneficios[ beneficioCodigo=" + beneficioCodigo + " ]";
    }

    public TipoBeneficio getTipoBeneficio() {
        return tipoBeneficio;
    }

    public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
        this.tipoBeneficio = tipoBeneficio;
    }

    @Override
    public Long getId() {
        return Long.valueOf(this.beneficioCodigo);

    }

    public List<CsbffBeneficios> getCsbffBeneficiosList() {
        if (this.csbffBeneficiosList == null) {
            this.csbffBeneficiosList = new ArrayList<>();
        }
        
        return csbffBeneficiosList;
    }

    public void setCsbffBeneficiosList(List<CsbffBeneficios> csbffBeneficiosList) {
        this.csbffBeneficiosList = csbffBeneficiosList;
    }

}
