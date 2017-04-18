/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.modelOld;

import br.org.gdt.enums.Sexo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_habilidade", sequenceName = "seq_habilidade", allocationSize = 1)
public class RecVaga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habilidade")
    private int vag_id;
    private String vag_descricao;
    private Sexo vag_sexo;
    @Temporal(TemporalType.DATE)
    private Date vag_dtvencimento;
    private double vag_salario;
    private String vag_status;
    @ManyToMany
    private List<RecHabilidade> vag_habilidades;
    @ManyToOne
    private RecGrauEnsino vag_grauensino;

    public int getVag_id() {
        return vag_id;
    }

    public void setVag_id(int vag_id) {
        this.vag_id = vag_id;
    }

    public String getVag_descricao() {
        return vag_descricao;
    }

    public void setVag_descricao(String vag_descricao) {
        this.vag_descricao = vag_descricao;
    }

    public Sexo getVag_sexo() {
        return vag_sexo;
    }

    public void setVag_sexo(Sexo vag_sexo) {
        this.vag_sexo = vag_sexo;
    }

    public Date getVag_dtvencimento() {
        return vag_dtvencimento;
    }

    public void setVag_dtvencimento(Date vag_dtvencimento) {
        this.vag_dtvencimento = vag_dtvencimento;
    }

    public double getVag_salario() {
        return vag_salario;
    }

    public void setVag_salario(double vag_salario) {
        this.vag_salario = vag_salario;
    }

    public String getVag_status() {
        return vag_status;
    }

    public void setVag_status(String vag_status) {
        this.vag_status = vag_status;
    }
}
