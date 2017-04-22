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
    private long eveId;
    private boolean eveEventoVariavel;
    private String eveNome;
    private String eveFormula;
    private boolean eveProvento;
    private boolean eveIncideINSS;
    private boolean eveIncideFGTS;
    private boolean eveIncideIR;
    private boolean eveAtivo;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento")
    public long getEveId() {
        return this.eveId;
    }

    public void setEveId(long eveId) {
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

    public String getEveFormula() {
        return eveFormula;
    }

    public void setEveFormula(String eveFormula) {
        this.eveFormula = eveFormula;
    }

    public boolean isEveProvento() {
        return eveProvento;
    }

    public void setEveProvento(boolean eveProvento) {
        this.eveProvento = eveProvento;
    }

    public boolean isEveIncideINSS() {
        return eveIncideINSS;
    }

    public void setEveIncideINSS(boolean eveIncideINSS) {
        this.eveIncideINSS = eveIncideINSS;
    }

    public boolean isEveIncideFGTS() {
        return eveIncideFGTS;
    }

    public void setEveIncideFGTS(boolean eveIncideFGTS) {
        this.eveIncideFGTS = eveIncideFGTS;
    }

    public boolean isEveIncideIR() {
        return eveIncideIR;
    }

    public void setEveIncideIR(boolean eveIncideIR) {
        this.eveIncideIR = eveIncideIR;
    }

    public boolean isEveAtivo() {
        return eveAtivo;
    }

    public void setEveAtivo(boolean eveAtivo) {
        this.eveAtivo = eveAtivo;
    }

}
