package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_horas_trabalhadas", sequenceName = "seq_fp_horas_trabalhadas", allocationSize = 1)
@Table(name = "fp_horas_trabalhadas")
public class FpHorasTrabalhadas implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long horId;
    private int horPessoa;
    private double horHorasNormais;
    private double horHorasFaltas;
    private double horHoras50;
    private double horHoras100;
    private double horHorasNoturnas;
    private FpPeriodo horFpPeriodo;

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

    public double getHorHorasFaltas() {
        return horHorasFaltas;
    }

    public void setHorHorasFaltas(double horHorasFaltas) {
        this.horHorasFaltas = horHorasFaltas;
    }

    @ManyToOne
    public FpPeriodo getHorFpPeriodo() {
        return horFpPeriodo;
    }

    public void setHorFpPeriodo(FpPeriodo horFpPeriodo) {
        this.horFpPeriodo = horFpPeriodo;
    }

}
