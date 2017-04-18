package br.org.gdt.modelOld;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarefa")
public class Tarefa implements java.io.Serializable {
    @Column(name = "dataconclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataconclusao;
    @Column(name = "dataprevista")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataprevista;
    @JoinColumn(name = "bloco_id", referencedColumnName = "id")
    @ManyToOne
    private Bloco blocoId;

    private long id;
    private String titulo;
    private String descricao;
    private Date dataPrevista;
    private Date dataConclusao;
    private String status;
    private Bloco bloco;

    public Tarefa() {
    }

    public Tarefa(long id, Bloco bloco) {
        this.id = id;
        this.bloco = bloco;
    }

    public Tarefa(long id, String titulo, String descricao, Date dataPrevista, Date dataConclusao, String status, Bloco bloco) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPrevista = dataPrevista;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.bloco = bloco;
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

    @Column(name = "titulo", length = 100)
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "descricao", length = 65535)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataPrevista", length = 19)
    public Date getDataPrevista() {
        return this.dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dataConclusao", length = 19)
    public Date getDataConclusao() {
        return this.dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Column(name = "status", length = 45)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Date getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(Date dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public Date getDataprevista() {
        return dataprevista;
    }

    public void setDataprevista(Date dataprevista) {
        this.dataprevista = dataprevista;
    }

    public Bloco getBlocoId() {
        return blocoId;
    }

    public void setBlocoId(Bloco blocoId) {
        this.blocoId = blocoId;
    }

}
