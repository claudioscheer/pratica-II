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
    private double valorBaseINSS;
    private double valorBaseFGTS;
    private double valorBaseIRRF;
    private double totalVencimentos;
    private double totalDescontos;
    private double totalLiquido;
    private double valorFGTS;

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

    @OrderBy("evpEvento.eveId ASC")
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

    public double getValorBaseINSS() {
        return valorBaseINSS;
    }

    public void setValorBaseINSS(double valorBaseINSS) {
        this.valorBaseINSS = valorBaseINSS;
    }

    public double getValorBaseFGTS() {
        return valorBaseFGTS;
    }

    public void setValorBaseFGTS(double valorBaseFGTS) {
        this.valorBaseFGTS = valorBaseFGTS;
    }

    public double getValorBaseIRRF() {
        return valorBaseIRRF;
    }

    public void setValorBaseIRRF(double valorBaseIRRF) {
        this.valorBaseIRRF = valorBaseIRRF;
    }

    public double getTotalVencimentos() {
        return totalVencimentos;
    }

    public void setTotalVencimentos(double totalVencimentos) {
        this.totalVencimentos = totalVencimentos;
    }

    public double getTotalDescontos() {
        return totalDescontos;
    }

    public void setTotalDescontos(double totalDescontos) {
        this.totalDescontos = totalDescontos;
    }

    public double getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(double totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public double getValorFGTS() {
        return valorFGTS;
    }

    public void setValorFGTS(double valorFGTS) {
        this.valorFGTS = valorFGTS;
    }

}
