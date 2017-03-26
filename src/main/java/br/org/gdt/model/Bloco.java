package br.org.gdt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bloco")
public class Bloco implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long id;
    private String descricao;

    public Bloco() {
    }

    public Bloco(long id) {
        this.id = id;
    }

    public Bloco(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "descricao", length = 100)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
