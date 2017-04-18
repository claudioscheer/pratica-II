package br.org.gdt.modelOld;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_tabela", sequenceName = "seq_fp_tabela", allocationSize = 1)
@Table(name = "fp_tabela")
public class FpTabela implements java.io.Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "tabid")
    private Long tabid;
    @Basic(optional = false)
    @Column(name = "tabativo")
    private boolean tabativo;
    @Column(name = "tabnome")
    private String tabnome;

    private static final long serialVersionUID = -2790083349568956163L;
    private long tabId;
    private String tabNome;
    private boolean tabAtivo;
    private List<FpFaixa> tabFaixas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tabela")
    public long getTabId() {
        return tabId;
    }

    public void setTabId(long tabId) {
        this.tabId = tabId;
    }

    public String getTabNome() {
        return tabNome;
    }

    public void setTabNome(String tabNome) {
        this.tabNome = tabNome;
    }

    public boolean isTabAtivo() {
        return tabAtivo;
    }

    public void setTabAtivo(boolean tabAtivo) {
        this.tabAtivo = tabAtivo;
    }

    @OneToMany(mappedBy = "faiTabela", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<FpFaixa> getTabFaixas() {
        if (this.tabFaixas == null) {
            this.tabFaixas = new ArrayList<>();
        }
        return tabFaixas;
    }

    public void setTabFaixas(List<FpFaixa> tabFaixas) {
        this.tabFaixas = tabFaixas;
    }

    public void addFaixa(FpFaixa fpFaixa) {
        if (fpFaixa != null) {
            fpFaixa.setFaiTabela(this);
            this.getTabFaixas().add(fpFaixa);
        }
    }

    public FpTabela() {
    }

    public FpTabela(Long tabid) {
        this.tabid = tabid;
    }

    public FpTabela(Long tabid, boolean tabativo) {
        this.tabid = tabid;
        this.tabativo = tabativo;
    }

    public Long getTabid() {
        return tabid;
    }

    public void setTabid(Long tabid) {
        this.tabid = tabid;
    }

    public boolean getTabativo() {
        return tabativo;
    }

    public void setTabativo(boolean tabativo) {
        this.tabativo = tabativo;
    }

    public String getTabnome() {
        return tabnome;
    }

    public void setTabnome(String tabnome) {
        this.tabnome = tabnome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabid != null ? tabid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpTabela)) {
            return false;
        }
        FpTabela other = (FpTabela) object;
        if ((this.tabid == null && other.tabid != null) || (this.tabid != null && !this.tabid.equals(other.tabid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpTabela[ tabid=" + tabid + " ]";
    }

}
