package br.org.gdt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Larissa Guder <lariguder10@gmail.com>
 */
@Entity
@SequenceGenerator(name = "seq_fp_tipofolha", sequenceName = "seq_fp_tipofolha", allocationSize = 1)
@Table(name = "fp_tipofolha")
public class FpTipoFolha implements java.io.Serializable {

    private static final long serialVersionUID = -2790083349568956163L;

    private int tipoId;
    private String tipoDescricao;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fp_tipofolha")
    public int getTipoId() {
        return this.tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

}
