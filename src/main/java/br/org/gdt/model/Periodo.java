package br.org.gdt.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Larissa Guder <lariguder10@gmail.com>
 */
@Entity
@SequenceGenerator(name = "seq_periodo", sequenceName = "seq_periodo", allocationSize = 1)
@Table(name = "periodo")
public class Periodo implements Serializable {

    private long id;
    private int mes;
    private int ano;
    private int diasUteis;

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDiasUteis() {
        return diasUteis;
    }

    public void setDiasUteis(int diasUteis) {
        this.diasUteis = diasUteis;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_periodo")
    @Column(name = "id")
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
        @Override
    public String toString() {
        return "Periodo{" + "id=" + id + ", mes=" + mes + ", ano=" + ano + ", diasUteis=" + diasUteis+ '}';
    }

}
