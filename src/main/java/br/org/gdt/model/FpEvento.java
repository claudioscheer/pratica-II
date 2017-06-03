package br.org.gdt.model;

import br.org.gdt.enums.FpTipoEvento;
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
    private String eveNome;
    private FpTipoEvento eveTipoEvento;
    private boolean eveIncideINSS;
    private boolean eveIncideFGTS;
    private boolean eveIncideIRRF;
    private boolean evePermiteExcluir;
    private boolean eveNaoAlteraFolha;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_evento")
    public long getEveId() {
        return this.eveId;
    }

    public void setEveId(long eveId) {
        this.eveId = eveId;
    }

    public String getEveNome() {
        return eveNome;
    }

    public void setEveNome(String eveNome) {
        this.eveNome = eveNome;
    }

    public FpTipoEvento getEveTipoEvento() {
        return eveTipoEvento;
    }

    public void setEveTipoEvento(FpTipoEvento eveTipoEvento) {
        this.eveTipoEvento = eveTipoEvento;
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

    public boolean isEveIncideIRRF() {
        return eveIncideIRRF;
    }

    public void setEveIncideIRRF(boolean eveIncideIRRF) {
        this.eveIncideIRRF = eveIncideIRRF;
    }

    public boolean isEvePermiteExcluir() {
        return evePermiteExcluir;
    }

    public void setEvePermiteExcluir(boolean evePermiteExcluir) {
        this.evePermiteExcluir = evePermiteExcluir;
    }

    public boolean isEveNaoAlteraFolha() {
        return eveNaoAlteraFolha;
    }

    public void setEveNaoAlteraFolha(boolean eveNaoAlteraFolha) {
        this.eveNaoAlteraFolha = eveNaoAlteraFolha;
    }

}
