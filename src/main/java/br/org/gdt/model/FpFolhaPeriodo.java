package br.org.gdt.model;

import br.org.gdt.enums.FpStatusFolhaPeriodo;
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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name = "seq_fp_folha_periodo", sequenceName = "seq_fp_folha_periodo", allocationSize = 1)
@Table(name = "fp_folha_periodo")
public class FpFolhaPeriodo implements java.io.Serializable, Cloneable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long forId;
    private RecPessoa forPessoa;
    private FpPeriodo forPeriodo;
    private Date forGeradaEm;
    private List<FpEventoPeriodo> forEventos;
    private FpStatusFolhaPeriodo forStatusFolhaPeriodo;
    private double forValorBaseINSS;
    private double forValorBaseFGTS;
    private double forValorBaseIRRF;
    private double forTotalVencimentos;
    private double forTotalDescontos;
    private double forTotalLiquido;
    private double forValorFGTS;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_folha_periodo")
    public long getForId() {
        return this.forId;
    }

    public void setForId(long forId) {
        this.forId = forId;
    }

    @ManyToOne
    public RecPessoa getForPessoa() {
        return forPessoa;
    }

    public void setForPessoa(RecPessoa forPessoa) {
        this.forPessoa = forPessoa;
    }

    @ManyToOne
    public FpPeriodo getForPeriodo() {
        return forPeriodo;
    }

    public void setForPeriodo(FpPeriodo forPeriodo) {
        this.forPeriodo = forPeriodo;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getForGeradaEm() {
        return forGeradaEm;
    }

    public void setForGeradaEm(Date forGeradaEm) {
        this.forGeradaEm = forGeradaEm;
    }

    public FpStatusFolhaPeriodo getForStatusFolhaPeriodo() {
        return forStatusFolhaPeriodo;
    }

    public void setForStatusFolhaPeriodo(FpStatusFolhaPeriodo forStatusFolhaPeriodo) {
        this.forStatusFolhaPeriodo = forStatusFolhaPeriodo;
    }

    //@OrderBy("evpEvento.eveId ASC")
    @OneToMany(mappedBy = "evpFolhaPeriodo", orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public List<FpEventoPeriodo> getForEventos() {
        if (forEventos == null) {
            forEventos = new ArrayList<>();
        }
        return forEventos;
    }

    public void setForEventos(List<FpEventoPeriodo> forEventos) {
        this.forEventos = forEventos;
    }

    public void addForEvento(FpEventoPeriodo fpEventoPeriodo) {
        if (fpEventoPeriodo != null) {
            fpEventoPeriodo.setEvpFolhaPeriodo(this);
            this.getForEventos().add(fpEventoPeriodo);
        }
    }

    public double getForValorBaseINSS() {
        return forValorBaseINSS;
    }

    public void setForValorBaseINSS(double forValorBaseINSS) {
        this.forValorBaseINSS = forValorBaseINSS;
    }

    public double getForValorBaseFGTS() {
        return forValorBaseFGTS;
    }

    public void setForValorBaseFGTS(double forValorBaseFGTS) {
        this.forValorBaseFGTS = forValorBaseFGTS;
    }

    public double getForValorBaseIRRF() {
        return forValorBaseIRRF;
    }

    public void setForValorBaseIRRF(double forValorBaseIRRF) {
        this.forValorBaseIRRF = forValorBaseIRRF;
    }

    public double getForTotalVencimentos() {
        return forTotalVencimentos;
    }

    public void setForTotalVencimentos(double forTotalVencimentos) {
        this.forTotalVencimentos = forTotalVencimentos;
    }

    public double getForTotalDescontos() {
        return forTotalDescontos;
    }

    public void setForTotalDescontos(double forTotalDescontos) {
        this.forTotalDescontos = forTotalDescontos;
    }

    public double getForTotalLiquido() {
        return forTotalLiquido;
    }

    public void setForTotalLiquido(double forTotalLiquido) {
        this.forTotalLiquido = forTotalLiquido;
    }

    public double getForValorFGTS() {
        return forValorFGTS;
    }

    public void setForValorFGTS(double forValorFGTS) {
        this.forValorFGTS = forValorFGTS;
    }

}
