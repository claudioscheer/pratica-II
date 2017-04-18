package br.org.gdt.modelOld;

import br.org.gdt.model.FpEventosTipoFolha;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@SequenceGenerator(name = "seq_fp_tipo_folha", sequenceName = "seq_fp_tipo_folha", allocationSize = 1)
@Table(name = "fp_tipo_folha")
public class FpTipoFolha implements java.io.Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "tpf_id")
    private Integer tpfId;
    @Basic(optional = false)
    @Column(name = "tipoid")
    private long tipoid;
    @Column(name = "tipodescricao")
    private String tipodescricao;
    @OneToMany(mappedBy = "tpfIdFpTipoFolha")
    private List<FpEventosTipoFolha> fpEventosTipoFolhaList;

    private static final long serialVersionUID = -2790083349568956163L;
    private long tipoId;
    private String tipoDescricao;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tipo_folha")
    public long getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(long tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public FpTipoFolha() {
    }

    public FpTipoFolha(Integer tpfId) {
        this.tpfId = tpfId;
    }

    public FpTipoFolha(Integer tpfId, long tipoid) {
        this.tpfId = tpfId;
        this.tipoid = tipoid;
    }

    public Integer getTpfId() {
        return tpfId;
    }

    public void setTpfId(Integer tpfId) {
        this.tpfId = tpfId;
    }

    public long getTipoid() {
        return tipoid;
    }

    public void setTipoid(long tipoid) {
        this.tipoid = tipoid;
    }

    public String getTipodescricao() {
        return tipodescricao;
    }

    public void setTipodescricao(String tipodescricao) {
        this.tipodescricao = tipodescricao;
    }

    @XmlTransient
    @JsonIgnore
    public List<FpEventosTipoFolha> getFpEventosTipoFolhaList() {
        return fpEventosTipoFolhaList;
    }

    public void setFpEventosTipoFolhaList(List<FpEventosTipoFolha> fpEventosTipoFolhaList) {
        this.fpEventosTipoFolhaList = fpEventosTipoFolhaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tpfId != null ? tpfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpTipoFolha)) {
            return false;
        }
        FpTipoFolha other = (FpTipoFolha) object;
        if ((this.tpfId == null && other.tpfId != null) || (this.tpfId != null && !this.tpfId.equals(other.tpfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpTipoFolha[ tpfId=" + tpfId + " ]";
    }

}
