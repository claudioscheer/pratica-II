package br.org.gdt.modelOld;

import br.org.gdt.enums.TipoValorFaixa;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seq_fp_faixa", sequenceName = "seq_fp_faixa", allocationSize = 1)
@Table(name = "fp_faixa")
public class FpFaixa implements java.io.Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "faiid")
    private Long faiid;
    @Basic(optional = false)
    @Column(name = "faimaximo")
    private double faimaximo;
    @Basic(optional = false)
    @Column(name = "faiminimo")
    private double faiminimo;
    @Column(name = "faitipovalor")
    private Integer faitipovalor;
    @Basic(optional = false)
    @Column(name = "faivalor")
    private double faivalor;
    @JoinColumn(name = "faitabela_tabid", referencedColumnName = "tabid")
    @ManyToOne
    private FpTabela faitabelaTabid;

    private static final long serialVersionUID = -2790083349568956163L;
    private long faiId;
    private FpTabela faiTabela;
    private double faiMinimo;
    private double faiMaximo;
    private double faiValor;
    private TipoValorFaixa faiTipoValor;
    private int faiOrdem;

    public FpFaixa() {
    }

    public FpFaixa(int faiOrdem) {
        this.faiOrdem = faiOrdem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_faixa")
    public long getFaiId() {
        return faiId;
    }

    public void setFaiId(long faiId) {
        this.faiId = faiId;
    }

    @ManyToOne
    public FpTabela getFaiTabela() {
        return faiTabela;
    }

    public void setFaiTabela(FpTabela faiTabela) {
        this.faiTabela = faiTabela;
    }

    public double getFaiMinimo() {
        return faiMinimo;
    }

    public void setFaiMinimo(double faiMinimo) {
        this.faiMinimo = faiMinimo;
    }

    public double getFaiMaximo() {
        return faiMaximo;
    }

    public void setFaiMaximo(double faiMaximo) {
        this.faiMaximo = faiMaximo;
    }

    public double getFaiValor() {
        return faiValor;
    }

    public void setFaiValor(double faiValor) {
        this.faiValor = faiValor;
    }

    public TipoValorFaixa getFaiTipoValor() {
        return faiTipoValor;
    }

    public void setFaiTipoValor(TipoValorFaixa faiTipoValor) {
        this.faiTipoValor = faiTipoValor;
    }

    @Transient
    public int getFaiOrdem() {
        return faiOrdem;
    }

    public void setFaiOrdem(int faiOrdem) {
        this.faiOrdem = faiOrdem;
    }

    public FpFaixa(Long faiid) {
        this.faiid = faiid;
    }

    public FpFaixa(Long faiid, double faimaximo, double faiminimo, double faivalor) {
        this.faiid = faiid;
        this.faimaximo = faimaximo;
        this.faiminimo = faiminimo;
        this.faivalor = faivalor;
    }

    public Long getFaiid() {
        return faiid;
    }

    public void setFaiid(Long faiid) {
        this.faiid = faiid;
    }

    public double getFaimaximo() {
        return faimaximo;
    }

    public void setFaimaximo(double faimaximo) {
        this.faimaximo = faimaximo;
    }

    public double getFaiminimo() {
        return faiminimo;
    }

    public void setFaiminimo(double faiminimo) {
        this.faiminimo = faiminimo;
    }

    public Integer getFaitipovalor() {
        return faitipovalor;
    }

    public void setFaitipovalor(Integer faitipovalor) {
        this.faitipovalor = faitipovalor;
    }

    public double getFaivalor() {
        return faivalor;
    }

    public void setFaivalor(double faivalor) {
        this.faivalor = faivalor;
    }

    public FpTabela getFaitabelaTabid() {
        return faitabelaTabid;
    }

    public void setFaitabelaTabid(FpTabela faitabelaTabid) {
        this.faitabelaTabid = faitabelaTabid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faiid != null ? faiid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpFaixa)) {
            return false;
        }
        FpFaixa other = (FpFaixa) object;
        if ((this.faiid == null && other.faiid != null) || (this.faiid != null && !this.faiid.equals(other.faiid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpFaixa[ faiid=" + faiid + " ]";
    }

}
