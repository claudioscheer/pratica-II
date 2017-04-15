package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_evento", sequenceName = "seq_fp_evento", allocationSize = 1)
@Table(name = "fp_evento")
public class FpEvento implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private int eveId;
    private boolean eveEventoVariavel;
    private String eveNome;
    private String eveDescricao;
    private String eveFormula;
    private boolean eveAtivo;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento")
    public int getEveId() {
        return this.eveId;
    }

    public void setEveId(int eveId) {
        this.eveId = eveId;
    }

    public boolean isEveEventoVariavel() {
        return eveEventoVariavel;
    }

    public void setEveEventoVariavel(boolean eveEventoVariavel) {
        this.eveEventoVariavel = eveEventoVariavel;
    }

    public String getEveNome() {
        return eveNome;
    }

    public void setEveNome(String eveNome) {
        this.eveNome = eveNome;
    }

    public String getEveDescricao() {
        return eveDescricao;
    }

    public void setEveDescricao(String eveDescricao) {
        this.eveDescricao = eveDescricao;
    }

    public String getEveFormula() {
        return eveFormula;
    }

    public void setEveFormula(String eveFormula) {
        this.eveFormula = eveFormula;
    }

    public boolean isEveAtivo() {
        return eveAtivo;
    }

    public void setEveAtivo(boolean eveAtivo) {
        this.eveAtivo = eveAtivo;
    }

}
