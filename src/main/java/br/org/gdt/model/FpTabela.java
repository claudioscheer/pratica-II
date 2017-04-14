package br.org.gdt.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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

    private static final long serialVersionUID = -2790083349568956163L;
    private int tabId;
    private String tabNome;
    private boolean tabAtivo;
    private List<FpFaixa> tabFaixas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tabela")
    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
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

}
