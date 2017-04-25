package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_evento_variavel", sequenceName = "seq_fp_evento_variavel", allocationSize = 1)
@Table(name = "fp_evento_variavel")
public class FpEventoVariavel implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long evvId;
    private String evvDescricao;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento_variavel")
    public long getEvvId() {
        return this.evvId;
    }

    public void setEvvId(long evvId) {
        this.evvId = evvId;
    }

    public String getEvvDescricao() {
        return evvDescricao;
    }

    public void setEvvDescricao(String evvDescricao) {
        this.evvDescricao = evvDescricao;
    }

}
