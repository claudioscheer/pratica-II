package br.org.gdt.modelOld;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name = "seq_experiencia", sequenceName = "seq_experiencia", allocationSize = 1)
public class RecExperiencia implements Serializable {

   

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_experiencia")
    private int     exp_id;
    private String  exp_empresa;
    private String  exp_area;
    private String  exp_cargo;
    private double  exp_salario;
    @Temporal(TemporalType.DATE)
    private Date    exp_dtinicial;
    @Temporal(TemporalType.DATE)
    private Date    exp_dtfinal;
    private String  exp_atividade;
    private String  exp_motivosaida;
    @ManyToMany(mappedBy = "experiencias")
    private List<RecPessoa> recPessoas;

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }

    public String getExp_empresa() {
        return exp_empresa;
    }

    public void setExp_empresa(String exp_empresa) {
        this.exp_empresa = exp_empresa;
    }

    public String getExp_area() {
        return exp_area;
    }

    public void setExp_area(String exp_area) {
        this.exp_area = exp_area;
    }

    public String getExp_cargo() {
        return exp_cargo;
    }

    public void setExp_cargo(String exp_cargo) {
        this.exp_cargo = exp_cargo;
    }

    public double getExp_salario() {
        return exp_salario;
    }

    public void setExp_salario(double exp_salario) {
        this.exp_salario = exp_salario;
    }

    public Date getExp_dtinicial() {
        return exp_dtinicial;
    }

    public void setExp_dtinicial(Date exp_dtinicial) {
        this.exp_dtinicial = exp_dtinicial;
    }

    public Date getExp_dtfinal() {
        return exp_dtfinal;
    }

    public void setExp_dtfinal(Date exp_dtfinal) {
        this.exp_dtfinal = exp_dtfinal;
    }

    public String getExp_atividade() {
        return exp_atividade;
    }

    public void setExp_atividade(String exp_atividade) {
        this.exp_atividade = exp_atividade;
    }

    public String getExp_motivosaida() {
        return exp_motivosaida;
    }

    public void setExp_motivosaida(String exp_motivosaida) {
        this.exp_motivosaida = exp_motivosaida;
    }
}
