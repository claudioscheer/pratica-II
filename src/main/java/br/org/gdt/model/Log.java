package br.org.gdt.model;

import br.org.gdt.enums.LogModulo;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@SequenceGenerator(name = "seq_log", sequenceName = "seq_log", allocationSize = 1)
@Table(name = "log")
public class Log implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long id;
    private LogModulo modulo;
    private String descricao;
    private Date data;
    private String pessoa;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_log")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LogModulo getModulo() {
        return modulo;
    }

    public void setModulo(LogModulo modulo) {
        this.modulo = modulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

}
