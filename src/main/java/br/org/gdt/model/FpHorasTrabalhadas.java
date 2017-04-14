package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_horas_trabalhadas", sequenceName = "seq_fp_horas_trabalhadas", allocationSize = 1)
@Table(name = "fp_horas_trabalhadas")
public class FpHorasTrabalhadas implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private int id;
    private int pessoa;
    private double horasNormais;
    private double horasFaltas;
    private double horas50;
    private double horas100;
    private double horasNoturnas;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_horas_trabalhadas")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
    }

    public double getHorasNormais() {
        return 250;
    }

    public void setHorasNormais(double horasNormais) {
        this.horasNormais = horasNormais;
    }

    public double getHorasFaltas() {
        return horasFaltas;
    }

    public void setHorasFaltas(double horasFaltas) {
        this.horasFaltas = horasFaltas;
    }

    public double getHoras50() {
        return horas50;
    }

    public void setHoras50(double horas50) {
        this.horas50 = horas50;
    }

    public double getHoras100() {
        return horas100;
    }

    public void setHoras100(double horas100) {
        this.horas100 = horas100;
    }

    public double getHorasNoturnas() {
        return horasNoturnas;
    }

    public void setHorasNoturnas(double horasNoturnas) {
        this.horasNoturnas = horasNoturnas;
    }

    @Override
    public String toString() {
        return "HorasTrabalhadas{" + "id=" + id + ", pessoa=" + pessoa + ", horasNormais=" + horasNormais + ", horasFaltas=" + horasFaltas + ", horas50=" + horas50 + ", horas100=" + horas100 + ", horasNoturnas=" + horasNoturnas + '}';
    }

}
