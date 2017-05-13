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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_tabela", sequenceName = "seq_fp_tabela", allocationSize = 1)
@Table(name = "fp_tabela")
public class FpTabela implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long tabId;
    private String tabNome;
    private boolean tabPermiteExcluir;
    private List<FpTabelaVigencia> tabVigencias;

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

    public boolean isTabPermiteExcluir() {
        return tabPermiteExcluir;
    }

    public void setTabPermiteExcluir(boolean tabPermiteExcluir) {
        this.tabPermiteExcluir = tabPermiteExcluir;
    }

    @OrderBy("tabVigenciaData DESC")
    @OneToMany(mappedBy = "tabVigenciaTabela", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<FpTabelaVigencia> getTabVigencias() {
        if (this.tabVigencias == null) {
            this.tabVigencias = new ArrayList<>();
        }
        return tabVigencias;
    }

    public void setTabVigencias(List<FpTabelaVigencia> tabVigencias) {
        this.tabVigencias = tabVigencias;
    }

    public void addTabVigencia(FpTabelaVigencia fpTabelaVigencia) {
        if (fpTabelaVigencia != null) {
            fpTabelaVigencia.setTabVigenciaTabela(this);
            this.getTabVigencias().add(0, fpTabelaVigencia);
        }
    }

}
