package br.org.gdt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name = "seq_fp_tabela_vigencia", sequenceName = "seq_fp_tabela_vigencia", allocationSize = 1)
@Table(name = "fp_tabela_vigencia")
public class FpTabelaVigencia implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long tabVigenciaId;
    private Date tabVigenciaData;
    private FpTabela tabVigenciaTabela;
    private List<FpFaixa> tabVigenciaFaixas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tabela_vigencia")
    public long getTabVigenciaId() {
        return tabVigenciaId;
    }

    public void setTabVigenciaId(long tabVigenciaId) {
        this.tabVigenciaId = tabVigenciaId;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getTabVigenciaData() {
        return tabVigenciaData;
    }

    public void setTabVigenciaData(Date tabVigenciaData) {
        this.tabVigenciaData = tabVigenciaData;
    }

    @ManyToOne
    public FpTabela getTabVigenciaTabela() {
        return tabVigenciaTabela;
    }

    public void setTabVigenciaTabela(FpTabela tabVigenciaTabela) {
        this.tabVigenciaTabela = tabVigenciaTabela;
    }

    public void setTabVigenciaFaixas(List<FpFaixa> tabVigenciaFaixas) {
        this.tabVigenciaFaixas = tabVigenciaFaixas;
    }

    @OneToMany(mappedBy = "faiTabelaVigencia", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<FpFaixa> getTabVigenciaFaixas() {
        if (this.tabVigenciaFaixas == null) {
            this.tabVigenciaFaixas = new ArrayList<>();
        }
        return tabVigenciaFaixas;
    }

    public void addFaixa(FpFaixa fpFaixa) {
        if (fpFaixa != null) {
            fpFaixa.setFaiTabelaVigencia(this);
            this.getTabVigenciaFaixas().add(fpFaixa);
        }
    }

}
