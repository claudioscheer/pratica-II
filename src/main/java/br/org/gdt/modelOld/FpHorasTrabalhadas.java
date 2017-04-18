package br.org.gdt.modelOld;

import br.org.gdt.model.RecPessoa_1;
import java.math.BigDecimal;
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

@Entity
@SequenceGenerator(name = "seq_fp_horas_trabalhadas", sequenceName = "seq_fp_horas_trabalhadas", allocationSize = 1)
@Table(name = "fp_horas_trabalhadas")
public class FpHorasTrabalhadas implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hor_id")
    private Integer horId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "hor_horasfaltas")
    private BigDecimal horHorasfaltas;
    @Basic(optional = false)
    @Column(name = "hor_horas50")
    private BigDecimal horHoras50;
    @Basic(optional = false)
    @Column(name = "hor_horas100")
    private BigDecimal horHoras100;
    @Basic(optional = false)
    @Column(name = "hor_horasnoturnas")
    private BigDecimal horHorasnoturnas;
    @Basic(optional = false)
    @Column(name = "hor_horasnormais")
    private BigDecimal horHorasnormais;
    @Basic(optional = false)
    @Column(name = "horid")
    private long horid;
    @Basic(optional = false)
    @Column(name = "horhoras100")
    private double horhoras100;
    @Basic(optional = false)
    @Column(name = "horhoras50")
    private double horhoras50;
    @Basic(optional = false)
    @Column(name = "horhorasnormais")
    private double horhorasnormais;
    @Basic(optional = false)
    @Column(name = "horhorasnoturnas")
    private double horhorasnoturnas;
    @Basic(optional = false)
    @Column(name = "horpessoa")
    private int horpessoa;
    @Basic(optional = false)
    @Column(name = "horasfaltas")
    private double horasfaltas;
    @JoinColumn(name = "per_id_fp_periodo", referencedColumnName = "per_id")
    @ManyToOne
    private FpPeriodo perIdFpPeriodo;
    @JoinColumn(name = "rec_idpessoa", referencedColumnName = "rec_idpessoa")
    @ManyToOne(optional = false)
    private RecPessoa_1 recIdpessoa;

    private static final long serialVersionUID = -2790083349568956163L;
    private long horId;
    private int horPessoa;
    private double horHorasNormais;
    private double horHorasFaltas;
    private double horHoras50;
    private double horHoras100;
    private double horHorasNoturnas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_horas_trabalhadas")
    public long getHorId() {
        return this.horId;
    }

    public void setHorId(long horId) {
        this.horId = horId;
    }

    public int getHorPessoa() {
        return horPessoa;
    }

    public void setHorPessoa(int horPessoa) {
        this.horPessoa = horPessoa;
    }

    public double getHorHorasNormais() {
        return 220;
    }

    public void setHorHorasNormais(double horHorasNormais) {
        this.horHorasNormais = horHorasNormais;
    }

    public double getHorasFaltas() {
        return horHorasFaltas;
    }

    public void setHorasFaltas(double horasFaltas) {
        this.horHorasFaltas = horasFaltas;
    }

    public double getHorHoras50() {
        return horHoras50;
    }

    public void setHorHoras50(double horHoras50) {
        this.horHoras50 = horHoras50;
    }

    public double getHorHoras100() {
        return horHoras100;
    }

    public void setHorHoras100(double horas100) {
        this.horHoras100 = horas100;
    }

    public double getHorHorasNoturnas() {
        return horHorasNoturnas;
    }

    public void setHorHorasNoturnas(double horHorasNoturnas) {
        this.horHorasNoturnas = horHorasNoturnas;
    }

    public FpHorasTrabalhadas() {
    }

    public FpHorasTrabalhadas(Integer horId) {
        this.horId = horId;
    }

    public FpHorasTrabalhadas(Integer horId, BigDecimal horHorasfaltas, BigDecimal horHoras50, BigDecimal horHoras100, BigDecimal horHorasnoturnas, BigDecimal horHorasnormais, long horid, double horhoras100, double horhoras50, double horhorasnormais, double horhorasnoturnas, int horpessoa, double horasfaltas) {
        this.horId = horId;
        this.horHorasfaltas = horHorasfaltas;
        this.horHoras50 = horHoras50;
        this.horHoras100 = horHoras100;
        this.horHorasnoturnas = horHorasnoturnas;
        this.horHorasnormais = horHorasnormais;
        this.horid = horid;
        this.horhoras100 = horhoras100;
        this.horhoras50 = horhoras50;
        this.horhorasnormais = horhorasnormais;
        this.horhorasnoturnas = horhorasnoturnas;
        this.horpessoa = horpessoa;
        this.horasfaltas = horasfaltas;
    }

    public Integer getHorId() {
        return horId;
    }

    public void setHorId(Integer horId) {
        this.horId = horId;
    }

    public BigDecimal getHorHorasfaltas() {
        return horHorasfaltas;
    }

    public void setHorHorasfaltas(BigDecimal horHorasfaltas) {
        this.horHorasfaltas = horHorasfaltas;
    }

    public BigDecimal getHorHoras50() {
        return horHoras50;
    }

    public void setHorHoras50(BigDecimal horHoras50) {
        this.horHoras50 = horHoras50;
    }

    public BigDecimal getHorHoras100() {
        return horHoras100;
    }

    public void setHorHoras100(BigDecimal horHoras100) {
        this.horHoras100 = horHoras100;
    }

    public BigDecimal getHorHorasnoturnas() {
        return horHorasnoturnas;
    }

    public void setHorHorasnoturnas(BigDecimal horHorasnoturnas) {
        this.horHorasnoturnas = horHorasnoturnas;
    }

    public BigDecimal getHorHorasnormais() {
        return horHorasnormais;
    }

    public void setHorHorasnormais(BigDecimal horHorasnormais) {
        this.horHorasnormais = horHorasnormais;
    }

    public long getHorid() {
        return horid;
    }

    public void setHorid(long horid) {
        this.horid = horid;
    }

    public double getHorhoras100() {
        return horhoras100;
    }

    public void setHorhoras100(double horhoras100) {
        this.horhoras100 = horhoras100;
    }

    public double getHorhoras50() {
        return horhoras50;
    }

    public void setHorhoras50(double horhoras50) {
        this.horhoras50 = horhoras50;
    }

    public double getHorhorasnormais() {
        return horhorasnormais;
    }

    public void setHorhorasnormais(double horhorasnormais) {
        this.horhorasnormais = horhorasnormais;
    }

    public double getHorhorasnoturnas() {
        return horhorasnoturnas;
    }

    public void setHorhorasnoturnas(double horhorasnoturnas) {
        this.horhorasnoturnas = horhorasnoturnas;
    }

    public int getHorpessoa() {
        return horpessoa;
    }

    public void setHorpessoa(int horpessoa) {
        this.horpessoa = horpessoa;
    }

    public double getHorasfaltas() {
        return horasfaltas;
    }

    public void setHorasfaltas(double horasfaltas) {
        this.horasfaltas = horasfaltas;
    }

    public FpPeriodo getPerIdFpPeriodo() {
        return perIdFpPeriodo;
    }

    public void setPerIdFpPeriodo(FpPeriodo perIdFpPeriodo) {
        this.perIdFpPeriodo = perIdFpPeriodo;
    }

    public RecPessoa_1 getRecIdpessoa() {
        return recIdpessoa;
    }

    public void setRecIdpessoa(RecPessoa_1 recIdpessoa) {
        this.recIdpessoa = recIdpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horId != null ? horId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FpHorasTrabalhadas)) {
            return false;
        }
        FpHorasTrabalhadas other = (FpHorasTrabalhadas) object;
        if ((this.horId == null && other.horId != null) || (this.horId != null && !this.horId.equals(other.horId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.org.gdt.model.FpHorasTrabalhadas[ horId=" + horId + " ]";
    }

}
