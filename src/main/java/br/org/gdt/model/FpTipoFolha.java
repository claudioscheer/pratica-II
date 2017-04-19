package br.org.gdt.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "seq_fp_tipo_folha", sequenceName = "seq_fp_tipo_folha", allocationSize = 1)
@Table(name = "fp_tipo_folha")
public class FpTipoFolha implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;
    private long tipoId;
    private String tipoDescricao;
    private List<FpEvento> tipoEventos;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tipo_folha")
    public long getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(long tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<FpEvento> getTipoEventos() {
        if (this.tipoEventos == null) {
            this.tipoEventos = new ArrayList<>();
        }
        return tipoEventos;
    }

    public void setTipoEventos(List<FpEvento> tipoEventos) {
        this.tipoEventos = tipoEventos;
    }
}
